# Dockerizing a Spring Boot Microservice

> A practical, battle-tested step-by-step guide to make Dockerizing Spring Boot apps second nature. Aim: production-minded, repeatable, secure, and CI/CD-ready.

---

## TL;DR

1. Build an optimized JAR using Maven or Gradle.
    
2. Use a multi-stage Dockerfile for small images and fast builds.
    
3. Layer your image to exploit Docker cache.
    
4. Run the JVM with sensible memory flags and a non-root user.
    
5. Add health checks, config via env vars, and small runtime user.
    
6. Automate with docker-compose for local dev and GitHub Actions to build/push images.
    

---

## Why this matters (2-sentence science)

Docker images are reproducible environments. Multi-stage builds keep images minimal, which reduces attack surface and startup time because fewer bytes = fewer cold I/O operations.

---

## Prereqs

- JDK 17+ recommended (match your production platform)
    
- Maven or Gradle build in project root
    
- Docker installed locally
    
- (Optional) docker-compose
    
- GitHub repo and PAT for pushing images (or GHCR)
    

---

## File: `.dockerignore`

```
target/
build/
.gradle/
*.log
.idea/
.vscode/
*.iml
.DS_Store
.git

# Optional: exclude local secrets
src/main/resources/application-local.yml

```

---

## Multi-stage Dockerfile (Maven) — production-grade

```dockerfile
# Stage 1: build
FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /workspace
COPY pom.xml mvnw .
COPY .mvn .mvn
RUN mvn -B -f pom.xml -q dependency:go-offline
COPY src ./src
RUN mvn -B -f pom.xml -q -DskipTests package

# Stage 2: runtime
FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=target/*.jar
COPY --from=build /workspace/${JAR_FILE} app.jar

# Create non-root user
RUN addgroup --system spring && adduser --system --ingroup spring spring
USER spring

# JVM tuning and minimal attack surface
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar /app.jar"]

# Default memory options for containerized JVM (override via env)
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0 -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap"

EXPOSE 8080
HEALTHCHECK --interval=30s --timeout=5s --start-period=10s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1
```

Notes

- We build in a Maven image and copy the artifact to a small JRE image.
    
- `JAVA_OPTS` environment variable is used so you can override in Docker run or k8s.
    
- The healthcheck uses the Spring Boot actuator endpoint.
    

---

## Multi-stage Dockerfile (Gradle)

```dockerfile
# Stage 1: build
FROM gradle:9.2-jdk17 AS build
WORKDIR /workspace
COPY build.gradle settings.gradle gradlew .
COPY gradle gradle
RUN ./gradlew --no-daemon build -x test || true
COPY . .
RUN ./gradlew --no-daemon clean bootJar -x test

# Stage 2: runtime
FROM eclipse-temurin:17-jre-jammy
COPY --from=build /workspace/build/libs/*.jar app.jar
RUN addgroup --system spring && adduser --system --ingroup spring spring
USER spring
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"
ENTRYPOINT ["sh", "-c", "exec java $JAVA_OPTS -jar /app.jar"]
EXPOSE 8080
HEALTHCHECK --interval=30s --timeout=5s --start-period=10s --retries=3 \
  CMD curl -f http://localhost:8080/actuator/health || exit 1
```

---

## App-level: enable Actuator health endpoints

In `application.yml` or `application.properties` (only expose what you need in prod):

```yaml
management:
  endpoints:
    web:
      exposure:
        include: health,info
  endpoint:
    health:
      show-details: when_authorized

# Bind server.port via env if needed
server:
  port: ${PORT:8080}
```

---

## Running locally with Docker

Build the image

```bash
# From repo root
mvn -DskipTests package   # or ./gradlew bootJar
docker build -t yourhub/user-service:0.1.0 .
```

Run

```bash
docker run --rm -p 8080:8080 -e SPRING_PROFILES_ACTIVE=local yourhub/user-service:0.1.0
```

Override JVM flags

```bash
docker run --rm -e JAVA_OPTS="-Xms256m -Xmx512m" -p 8080:8080 yourhub/user-service:0.1.0
```

---

## Local development with `docker-compose`

`docker-compose.yml` for local dev with DB and service

```yaml
version: '3.8'
services:
  user-service:
    build: .
    ports:
      - '8080:8080'
    environment:
      - SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/users
      - SPRING_DATASOURCE_USERNAME=postgres
      - SPRING_DATASOURCE_PASSWORD=postgres
      - SPRING_PROFILES_ACTIVE=local
    depends_on:
      - db

  db:
    image: postgres:15
    environment:
      POSTGRES_DB: users
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    volumes:
      - pgdata:/var/lib/postgresql/data

volumes:
  pgdata:
```

Run

```bash
docker-compose up --build
```

---

## CI: GitHub Actions workflow to build, test, and push image to GHCR

`.github/workflows/docker-publish.yml`

```yaml
name: Build and Publish

on:
  push:
    branches: [ main ]

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - uses: actions/checkout@v4

      - name: Set up JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: 'temurin'
          java-version: '17'

      - name: Build with Maven
        run: mvn -B -DskipTests package

      - name: Login to GitHub Container Registry
        uses: docker/login-action@v2
        with:
          registry: ghcr.io
          username: ${{ github.actor }}
          password: ${{ secrets.GITHUB_TOKEN }}

      - name: Build and push Docker image
        uses: docker/build-push-action@v5
        with:
          push: true
          tags: ghcr.io/${{ github.repository_owner }}/${{ github.repository }}:latest
          file: ./Dockerfile
```

Notes

- Use `secrets.GITHUB_TOKEN` to publish to GHCR under the same org/user. For Docker Hub use `docker/login-action` with DOCKER_USERNAME and DOCKER_PASSWORD secrets.
    

---

## Security & best practices

- Do not bake secrets in images. Use environment variables or a secrets manager.
    
- Run as non-root user in the image.
    
- Minimal base image (JRE not full JDK) for runtime. Use distro with security patch cadence.
    
- Keep image small to reduce CVE attack surface.
    
- Enable static code analysis and dependency scanning in CI.
    

---

## API & code checklist for `user-service` before dockerizing

Use this checklist to "complete all APIs":

-  CRUD for User resource: create, read (by id, list with pagination), update, delete
    
-  Input validation and DTO separation
    
-  Authentication & Authorization stubs or integration (JWT or OAuth2)
    
-  Tests: unit tests for services, integration tests for controllers (use Testcontainers for DB)
    
-  API docs (Springdoc OpenAPI / Swagger UI) available on `/_docs` or `/swagger-ui.html`
    
-  Error handling: global `@ControllerAdvice`, consistent error body
    
-  Logging: structured logs (JSON optional), correlation id tracing
    
-  Metrics: actuator + prometheus endpoint
    
-  Health endpoints (ready/liveness) using `/actuator/health` and readiness probe logic
    

---

## Testing inside containers

- Use `Testcontainers` for integration tests to mirror the containerized DB environment.
    
- For smoke tests after docker run, `curl` the health endpoint and a couple of API calls.
    

Example smoke script

```bash
#!/usr/bin/env bash
set -e
BASE=http://localhost:8080
curl -fs $BASE/actuator/health
curl -fs $BASE/api/v1/users | jq '.' || true
```

---

## Kubernetes notes (short)

- Use `readinessProbe` and `livenessProbe` pointing to actuator endpoints.
    
- Set resource requests/limits and use the `JAVA_OPTS` to bind memory.
    

Example probe snippet

```yaml
readinessProbe:
  httpGet:
    path: /actuator/health/readiness
    port: 8080
  initialDelaySeconds: 10
  periodSeconds: 10

livenessProbe:
  httpGet:
    path: /actuator/health/liveness
    port: 8080
  initialDelaySeconds: 30
  periodSeconds: 20
```

---

## Troubleshooting common issues

- 1. App fails in container due to `java.lang.OutOfMemoryError`: lower heap, increase container memory or set `-XX:MaxRAMPercentage`. Use `-XshowSettings:vm` to debug.
        
- 2. Actuator 401 for health: check security config for actuator endpoints in production profile.
        
- 3. Image too large: remove build artifacts, use `jlink` for custom runtime image (advanced) or use distroless base.
        

---

## Example `README` snippet to add to repo

```
# user-service

Build locally: `mvn -DskipTests package`

Build image: `docker build -t yourhub/user-service:0.1.0 .`

Run locally: `docker run --rm -p 8080:8080 -e SPRING_PROFILES_ACTIVE=local yourhub/user-service:0.1.0`
```

---

## Next actions (suggested)

1. Ensure all APIs in checklist are implemented and tested.
    
2. Add Dockerfile and .dockerignore
    
3. Add `docker-compose.yml` for local dev.
    
4. Add GitHub Actions workflow to build and publish images.
    
5. Run smoke tests and iterate.
    

---

## References / small reading list

- Spring Boot docs: Actuator and externalized configuration
    
- Docker docs: multi-stage builds and caching
    
- Best practices: running Java in containers
    

---

_End of note. Ship it._