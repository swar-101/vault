Requirements:

1. Registered sellers will list their products with some selling price on the platform.
2. Registered buyers can add multiple of such products to their cart and buy them by placing an order if all the required products are in stock.
3. We need to maintain inventory of all the products for each seller.
4. Sometimes a product can be out of stock, interested users can subscribe to a notification which they will get when the product becomes available next.
5. We want to show advertisements to users depending upon their interests, previous shopping behaviour, etc. We have a list of interested categories for every user eg. Ram is interested in Tech, Clothing and Footwear. Now all the ads related to these categories should be shown to Ram.
6. Each advertisements has the following things: Name of the product, link to buy the product, category of the product (used to show ads to the users) etc.
   

---

## Solution 

```java

abstract class BaseModel {
	-id : long
	-createdAt: LocalDateTime
	-updatedAt: LocalDateTime
}

enum ProductType {
	ELECTRONIC, UTILITY, GROCERY, FOOD, TECH, CLOTHING, FOOTWEAR
}

class Product extends BaseModel {
	-name: String
	-type: ProductType
}

enum SellerStatus {
	REGISTERED, IN_PROCESS, NOT_REGISTERED
}

class Address extends BaseModel {
	-line1: String
	-line2: String
	-city: String
	-state: String
	-zipcode: String
	-country: String
}

class Seller extends BaseModel {
	-name: String
	-email: String 
	-address: Address
	-status: SellerStatus
}

class SellerProduct extends BaseModel {
	-seller: Seller
	-product: Product
	-price: double
	-description: String
}

enum WarehouseStatus {
	ACTIVE, CLOSED, UNDER_REPAIR 
}

class Warehouse extends BaseModel {
	-name: String
	-address: Address
	-warehouseStatus: WarehouseStatus
}

class SellerProductInventory extends BaseModel {
	-seller: Seller
	-product: Product
	-warehouse: Warehouse
	-quantity: Quantity
}

class User extends BaseModel {
	-name: String
	-address: Address
	-email: String
}

class CartItem extends BaseModel {
	-sellerProduct: SellerProduct
	-quatity: int
}

class Cart extends BaseModel {
	-user: User
	-items: List<CartItem>
}

enum Delivery {
	PLACED, ASSIGNED, RECEIVED, FAILED
}

class Order extends BaseModel {
	-user: User
	-deliveryStatus: DeliveryStatus
}

class OrderedProduct extends BaseModel {
	-order: Order
	-sellerProduct: SellerProduct
	-quantity: int
	-priceAtPurchase: double
}

class ProductAvailabilitySubscriber {
	-map: Map<Product, List<User>>

	+addSubscriber(userId: long, productId: long): void
	+removeSubscriber(userId: long, productId: long): void
	+getAllSubscribers(): List<User>
}

enum NotificationStatus {
	NOTIFIED, PENDING, FAILED
}

interface ProductAvailabilityNotifier {
	+notify(List<Long> userIds): Map<Long, NotificationStatus>  
}

// Observer pattern for advertisements

class userPreferenceObserver {
	+update(product: Product): void
}

class userPreferenceManager {
	-userPreferences: Map<Long, List<ProductType>>

	+notifyObservers(product: Product): void
}

class Advertisement extends BaseModel {
	String name;
	String productLink;
	ProductType category;
}
```