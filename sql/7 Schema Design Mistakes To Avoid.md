![[7-schema-design-mistakes-to-avoid.pnj.png]]
# 7 Schema Design Mistakes To Avoid

## Mistake 1: Storing Business Fields As Primary Key

Storing business fields as Primary Key in a table is particularly a bad idea. It might seem great at first, but these fields are subjected to change. Plus, we don't have control over these fields.  
The format and values for these fields are often determined by an external system or a company.

Imagine we're storing information about spare parts for a Lamborghini.  
And the company decides to change the format by adding another letter.  
This will mess up the database because **any change in the business field would break the existing references and cause inconsistencies or data loss in related tables**.

The purpose of Primary Key is different from a business relevant field.  
Although unique, business fields represent the uniqueness of the spare parts, not the table.  
The purpose of a Primary Key is to enable identifying each row in the table using a unique identifier.

**What's the solution?**

_**"Creating a new field for storing Primary Key a.k.a. the Surrogate Key"**_

> Use an auto-generated, immutable ID that never changes, ensuring stable and reliable references.

---

## Mistake 2: Storing Redundant Data

Some of the data we're storing could be unnecessary.

**Example:**

Let's say we have a `user` table with the following fields:

1. `person_id`
    
2. `name`
    
3. `dob`
    
4. `age`
    

We decide to store `age` because we need it in our application.

However, if we decide to store `age`, it's problematic.

Because `age` would need to be calculated every day based on the current date to ensure that the `age` value is up-to-date.

This introduces extra complexity into the DB system.

**What's the solution?**  
_**"Calculating age in the application or using an SQL query"**_

> Ensuring that derived fields like `age` are not stored and calculated only when needed **eliminates redundancy, avoids inconsistency, and keeps your data fresh.**

---

## Mistake 3: Naming Tables Using Spaces

Most databases expect table names to be made up of characters and underscores.  
A few examples:

1. In Camel Case: `CustomerOrder`
    
2. Single names: `customerorder`
    
3. Using underscores: `customer_order`
    

However, it's possible to add spaces to your table names. You do this by enclosing table names in double quotes.

Example: `"customer order"`  
This may seem like a good idea to make table names more readable, but it can make your queries messy and cause errors.  
Every time you write a query, you will have to mention the table names with these double quotes.

Example:

```sql
SELECT
    id, 
    order_date, 
    order_value 
FROM "customer order";
```

So, in your `UPDATE` queries, `SELECT` queries, or any other queries that include table names, you will have to mention them in double quotes.

If we forget to mention double quotes, the query won't run or would not give the result we're expecting.

**What's the solution?**

_**"Use underscore for table names to make them more readable."**_

---

## Mistake 4: Poor Or No Referential Integrity

**What's Referential Integrity?**  
It basically means that the data in your database is high-quality. We ensure this quality by introducing database constraints.

There are generally five types of constraints used in databases:

1. Primary Key
    
2. Foreign Key
    
3. Unique
    
4. Not Null
    
5. Check
    

If you have specific rules that need to be enforced on your data, it can be useful to create these constraints on the columns in your tables.

This will ensure that the data is valid and is not missing where it needs to be populated.

**What happens if we don't introduce constraints to our schema?**

- Duplicate values in the column that needs to be unique.
    
- IDs that refer to other records that don't exist.
    

You might think, "Can't we let our User Interface or the application handle these constraints?"

The answer is "Yes", we can definitely let the User Interface or the application handle these validations.  
But it's a good idea for our schema to include these constraints as well. This ensures that even if the data arrives via another system or process, it is handled and stored correctly.

It will also ensure Data Integrity even if the application updates or changes, which is always good to have.

**What's the solution?**

_**"Use these constraints to ensure that the data is stored correctly every time!"**_

---

## Mistake 5: Multiple Pieces Of Information In A Single Field

Ideally, each column is meant for one piece of information.

Let's take a look at this `customer` table:

|address_id|name|address|
|---|---|---|
|1|Mary|123 Maple Street, Austin, Texas, 73301, USA|
|2|John|456 Oak Avenue, Denver, Colorado, 80201, USA|
|3|Yoko|789 Sakura Lane, Tokyo, 100-0001, Japan|

The `address` field may seem like a single piece of information, but it's not. It includes:

1. Street Number
    
2. Street Name and Type
    
3. City
    
4. State
    
5. Country
    
6. Zip or Postal Code
    

It's usually beneficial to store the address as separate fields:

|address_id|name|street_number|street_name_and_type|city|state|zip_code|country|
|---|---|---|---|---|---|---|---|
|1|Mary|123|Maple St|Austin|Texas|73301|USA|
|2|John|456|Oak Ave|Denver|Colorado|80201|USA|
|3|Yoko|789|Sakura Lane|Tokyo|Tokyo Met.|100-0001|Japan|

This allows you to perform validations on different components of the address, such as valid zip code or street type.  
It also allows you to filter on different components, such as all addresses in a city, without performing string manipulation.

---

## Mistake 6: Storing Optional Types Of Data In Different Columns

A common example of this is phone numbers. Let's say we have a `customer` table and want to store different phone numbers they have:

1. Business Phone
    
2. Home Phone
    
3. Mobile Phone
    

A customer may not have a home phone record but might have a business phone.  
Another customer may have a mobile phone—or even none of them!

This would mean that some or all of the fields would be empty.

Also, what happens if you want to add a new type of phone number?  
You'd have to add new columns. Many of them may be empty!

**What's the solution?**  
_**"Store phone numbers and types in separate tables"**_

> This way, each row represents a single phone number and type, giving you full flexibility and scalability.

---

## Mistake 7: Using The Wrong Data Types And Sizes

Part of Schema Design is determining the data types and sizes for each column.  
Generally, there are three categories of data:

1. Number
    
2. Text
    
3. Date
    

But within these categories are many different data types.  
There are Number types depending on whether you want decimal places or not, and how large the number is.  
Data types also depend on which database you're using and are not standard across databases.

Choosing the right data type comes down to your knowledge of the data, your experience, and your knowledge of data types.

Making an appropriate choice makes a big difference!

The difference:

1. Quality of Data
    
2. Improves Performance
    
3. Reduce Storage
    

**Example 1:**  
Date values could be stored as numbers or as text fields:  
`Text: '20250103'`  
However, by choosing a valid date data type such as `DATETIME`:  
`DATETIME: '2025-01-03'`  
This will ensure only valid dates are stored, and these dates can be filtered and indexed properly.

**Example 2:**  
For storing fields such as the first name of the customer,  
instead of using `VARCHAR(2000)` which is overkill,  
a limit of 200 or 400 characters is usually enough:

|Field|Data Type|
|---|---|
|FirstName|`VARCHAR(200)`|
||or|
||`VARCHAR(400)`|

> Shorter fields = better performance and more accurate data validation.

**What's the solution?**  
_**"To work out an appropriate data type, consider what the data is being used for!"**_  
It is possible to change the data type later, but it can be hard.  
Get some sample data if you can.  
Look at the possible data types available in your database.

---