## 📁 Index

1. 🔑 Key Concepts
    
2. 📜 Why Logs Aren't Enough
    
3. ⚙️ Working Example
    
4. 🏭 Production Best Practices
    
5. 📋 TL;DR
    

---

## 🔑 Key Concepts

- **Recoverable vs. Irrecoverable**
    
    - **Recoverable**: Situations where the caller has a _reasonable_ way to handle the failure and continue execution (e.g., missing config file, network hiccup).
        
    - **Irrecoverable**: Indicates a bug or state that cannot be meaningfully recovered from (e.g., unexpected `null`, invalid business logic input).
        
- **External Resources**: Anything _outside_ your JVM that can fail independently:
    
    - File systems (I/O)
        
    - Network services (HTTP, sockets)
        
    - Databases
        
    - Message queues (Kafka, RabbitMQ)
        
- **Leaky & Brittle APIs**
    
    - **Leaky**: Method signatures expose low-level exceptions, revealing internal implementation details.
        
    - **Brittle**: Callers become tightly coupled to your exception types; internal changes force API and client code updates.
        

---

## 📜 Why Logs Aren't Enough

1. **Control Flow**: Exceptions alter execution (retry, fallback, abort); logs only record events.
    
2. **API Contracts**: Checked exceptions serve as compiler-enforced promises: callers must acknowledge and handle them.
    
3. **Rich Context**: Custom exception types can carry fields (error codes, metadata) beyond a simple log message.
    

---

## ⚙️ Working Example

```java
// 1) Checked exception for recoverable failures
public class ConfigMissingException extends Exception {
    public ConfigMissingException(String message) {
        super(message);
    }
}

// 2) Unchecked exception for programming or business-rule violations
public class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String message) {
        super(message);
    }
}

public class OrderProcessor {

    // Throws checked exception for missing or unreadable config
    public Properties loadConfig(String path) throws ConfigMissingException {
        try (FileInputStream in = new FileInputStream(path)) {
            Properties props = new Properties();
            props.load(in);
            return props;
        } catch (FileNotFoundException e) {
            throw new ConfigMissingException("Config file not found at: " + path);
        } catch (IOException e) {
            throw new ConfigMissingException("Error reading config: " + e.getMessage());
        }
    }

    // Unchecked exception for invalid business rule
    public void validateOrderAmount(double amount) {
        if (amount <= 0) {
            throw new InvalidOrderException(
                "Order amount must be positive, got: " + amount);
        }
    }

    public void process(String configPath, double orderAmount) {
        try {
            Properties cfg = loadConfig(configPath);
            validateOrderAmount(orderAmount);
            // ... process using cfg ...
            System.out.println("Processing order with config: " + cfg);
        } catch (ConfigMissingException e) {
            System.err.println("Configuration error: " + e.getMessage());
            // handle retry, fallback, or exit
        }
        // InvalidOrderException not caught here -> signals bug
    }

    public static void main(String[] args) {
        new OrderProcessor().process("app.properties", -50);
    }
}
```

---

## 🏭 Production Best Practices

- **Use Checked Exceptions** for external/resource failures when a caller can recover (I/O, DB, network).
    
- **Use Unchecked Exceptions** for programming errors or business-rule violations (invalid inputs, contract breaches).
    
- **Wrap Low-Level Exceptions** in domain-specific types to prevent leaking implementation details.
    
- **Document Exception Contracts**: Clearly state in Javadoc when and why each exception is thrown.
    
- **Provide Rich Metadata**: Include error codes or context fields in custom exceptions to aid diagnosis.
    

---

## 📋 TL;DR

|Scenario|Checked (`Exception`)|Unchecked (`RuntimeException`)|
|---|---|---|
|External/resource failures|✅|❌|
|Business-rule or programming errors|❌|✅|
|Enforced handling by caller|✅|❌|
|Cleaner, simpler API signatures|❌|✅|
|Protects API from low-level changes|✅ (when wrapped)|✅ (no leaks)|

> Keep your APIs stable and your error-handling intentional—don’t just rely on logs to tell the story! 😉

