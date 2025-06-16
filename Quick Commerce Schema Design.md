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
9. 