# Identity Fields

Fields which can be used for uniquely identifying an object are called **Identity Fields**. These fields are typically stable and do not change over time — they consistently define the object's uniqueness.

## Example:

```java
class User {
	private String id;
	private String name;
	private String email;
	private String phoneNumber;
	private boolean hasPet;
	private int age;
	private Address address;
}
```

In the `User` class above:

- The fields `id`, `name`, `email`, and `phoneNumber` are **Identity Fields**.
    
    - They help uniquely identify a specific `User` instance.
        
    - These fields are commonly used in `equals()` and `hashCode()` implementations.
        
- The fields `hasPet`, `age`, and `address` are [[State Fields]].
    
    - These represent the mutable state of the object and may change over time.
        

## Characteristics of Identity Fields:

- Often mapped to **primary keys** or **unique constraints** in a database.
    
- Should not change once set, especially if the object is part of a hash-based collection like [[HashSet]] or [[HashMap]].
    
- Used in determining **logical equality** between objects.
    

