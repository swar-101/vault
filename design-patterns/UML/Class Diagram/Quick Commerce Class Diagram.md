
Requirements:

1. There are multiple stores which have items that users need delivered at their doorsteps.
2. There are multiple delivery partners who can pickup items from a store and deliver it to a user's home.
3. Some partners can be online i.e. they should be considered for making a delivery where as some can be offline, these partners should not be considered for making delivery.
4. At any given point in time we can have multiple available partners and multiple orders (is a user trying to order grocery items) live in the system. To match a partner with a task, we want to consider the distance between the partner's current location and the distance from the pickup store, partner who is closest to the store should get the task assigned. Although the criteria for matching a partner and a task can change in the future.
5. Every store has a limited inventory of items. Before accepting an order we need to make sure that we have the required quantity of items to fulfil that order.
6. The partners mobile app will send their latest location every few seconds, we need to store this information so that we can track partners. 

---
## Solution

Relationships:
1. Many `Store` with many `Item`.
2. Many `Order` with `DeliveryPartner`.
3. Every `DeliveryPartner` has a `Location`.
4. A `Delivery` has one to many `Orders`.
5. A `DeliveryPartner` has zero to many `Delivery`.
6. A `DeliveryPartner` has `DeliveryPartnerStatus`: ONLINE, OFFLINE.
7. There is `DeliveryAssignmentStrategy`, where `ClosestPartnerDeliveryAssignmentStrategy` is the closest  


Class Diagram: 

```java
@startuml

class BaseModel {
	- id: long
	- createdAt: LocalDateTime
	- updatedAt: LocalDateTime
}

class Address extends BaseModel {
	- line1: String
	- line2: String
	- city: String
	- state: String
	- zipcode: int
	- country: String
}

class User extends BaseModel {
	- name: String 
	- email: String
	- phoneNumber: int
}

interface Publisher {
	~publishDistanceUpdate(distance: double): void
}

class DeliveryPartner extends BaseModel implements Publisher {
	- name: String
	- email: String
	- phoneNumber: int

	+publishDistanceUpdate(distance: double): void
}

interface Subscriber {
	~updateDistance(partnerId: long, distance: double): void
}

class DistanceTracker implements Subscriber {
	+updateDistance(partnerId: long, distance: double): void
}

enum ItemType {
	GROCERY, VEGETABLE, GADGET
}

class Item extends BaseModel {
	- name: String
	- type: ItemType
}

class Order extends BaseModel {
	- items: List<Item>
	- total_amount: int
}

class Location extends BaseModel {
	-latitude: double
	-longitude: double
}

class PickupStore extends BaseModel {
	-location: Location
	-address: Address
}

interface DeliveryPartnerAssignmentStrategy {
	~assignPartner(deliveryPartners: List<DeliveryPartner> partners, store: PickupStore): Delivery
}

class ClosestDeliveryPartnerAssignmentStrategy implements DeliveryPartnerAssignmentStrategy {

	+assignPartner(deliveryPartners: List<DeliveryPartner> partners, store: PickupStore): Delivery
}

enum InventoryStatus {
	AVAILABLE, UNAVAILABLE, FAILED
}

class InventoryResponse {
	-status: InventoryStatus
}

interface InventoryService {
	~checkInventory(order: Order): InventoryResponse
}

class InventoryServiceImpl implements InventoryService {
	+checkInventory(order: Order): InventoryResponse
}

enum OrderStatus {
	ORDERED, CANCELLED, FAILED
}

class OrderResponse {
	-status: OrderStatus
}

interface OrderService {
	~acceptOrder(orderId: long): OrderResponse 
} 

class OrderServiceImpl implements OrderService {
	+acceptOrder(orderId: long): OrderResponse 
} 

interface DeliveryAssignmentService {
	~assignDelivery(order: Order, store: PickupStore): Delivery
}

enum DeliveryAssignmentStatus {
	ASSIGNED, PENDING, FAILED
}

class DeliveryAssignmentResponse {
	-status: DeliverAssignmentStatus
}

class DeliveryAssignmentServiceImpl implements DeliveryAssignmentService {
	+assignDelivery(order: Order, store: PickupStore): DeliveryAssignmentResponse
}

enum DeliveryResponseStatus {
	DELIVERED, RETURNED, FAILED, NOT_ACCEPTED
}

class DeliveryResponse {
	-status: DeliveryResponseStatus
}

interface DeliveryService {
	~deliverOrder(userId: long, orderId: long): DeliveryResponse
}


class DeliveryServiceImpl implements DeliveryService {
	-deliverOrder(userId: long, orderId: long): DeliveryResponse
}

@enduml
```
