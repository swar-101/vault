Requirements:

1. There are multiple stores which have items that users need delivered at their doorsteps.
2. There are multiple delivery partners who can pickup items from a store and deliver it to a user's home.
3. Some partners can be online i.e. they should be considered for making a delivery where as some can be offline, these partners should not be considered for making delivery.
4. At any given point in time we can have multiple available partners and multiple orders (is a user trying to order grocery items) live in the system. To match a partner with a task, we want to consider the distance between the partner's current location and the distance from the pickup store, partner who is closest to the store should get the task assigned. Although the criteria for matching a partner and a task can change in the future.
5. Every store has a limited inventory of items. Before accepting an order we need to make sure that we have the required quantity of items to fulfil that order.
6. The partners mobile app will send their latest location every few seconds, we need to store this information so that we can track partners.
   
   ---

## Solution 

1. Many stores have many items.
2. A store has many delivery partners.
3. Delivery partners maybe online or offline.
4. A user can have multiple orders.
5. An order can have multiple items.
6. A delivery has one delivery partners.
7. A delivery partner can delivery many deliveries.
8. A store has inventory. 


table: address
fields: 
- id (PK)
- line1 
- line2
- street
- city
- zipcode
- country


table: store
fields: 
- id (PK)
- address_id (FK)
- name

table: user
fields:
- id (PK)
- address_id (FK)
- name
- phone_number
- email

table: item
fields:
- id (PK)
- name
- type
- created_at
- updated_at

table: store_item
fields: 
- id (PK)
- store_id (FK)
- item_id (FK)
- quantity
- created_at 
- updated_at

table: delivery_partner
fields:
- id (PK)
- name
- address_id (FK)
- phone_number
- email
- base_store_id (FK)

table: order
fields: 
- id (PK)
- user_id (FK)
- store_id (FK)
- delivery_partner_id (FK, nullable)
- scheduled_time
- status (enum: PLACED, ASSIGNED, DELIVERED, CANCELLED)
- total_price
- created_at
- updated_at

table: order_item
fields: 
- id (PK)
- order_id (FK)
- store_item_id (FK)
- quantity

table: partner_location
fields: 
- id (PK)
- delivery_partner_id (FK)
- latitude
- longitude
- timestamp

table: partner_status
fields:
- id (PK)
- delivery_partner_id (FK)
- is_online
- last_updated