

# Member Service

### Why use a separate Member Service? 

The Member Service isolated participant validation concerns from
token lifecycle operations.

Before token creation or transaction processing, the system needed
to validate entities such as members, merchants, acquirers,
network information and card-related attributes.

Keeping this responsibility separate improved modularity and
allowed independent evolution of validation rules.



### Why did you use both Kafka and gRPC?

The POC was designed to evaluate both synchronous and asynchronous communication patterns. We used gRPC for low-latency request-response interactions such as member validation, and Kafka for event-driven decoupled workflows. To avoid coupling the business logic to a specific transport mechanism, we introduced a strategy abstraction that allowed switching between communication models through configuration.



# Maskit4j

A reusable log masking framework that intercepts log messages before they are written and masks sensitive information based on configurable rules.

#### Why did you approach it like this?
I preferred centralized enforcement because security requirements are easier to guarantee when developers don't have to remember masking rules.







# Service Profile 

