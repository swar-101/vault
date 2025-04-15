# State Fields

**State Fields** are properties of an object that can change over time. They describe the _current condition_ of the object rather than its _identity_.

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

- `hasPet`, `age`, and `address` are **State Fields**.
    
    - These fields are mutable.
        
    - Should generally be excluded from `equals()` and `hashCode()` unless absolutely necessary.
        

## Characteristics of State Fields:

- Represent business state (e.g. whether a user is active or not).
    
- May change multiple times during the lifecycle of the object.
    
- Including these in equality operations may lead to inconsistent behavior in collections.
    

## Summary:

- Use **Identity Fields** to define who/what an object _is_.
    
- Use **State Fields** to define what condition or attributes an object _currently has_.
    

This separation helps maintain consistent behavior in object comparison, persistence, and when working with collections.

---

Would you like to add backlinks to related topics like `@EqualsAndHashCode`, `hashCode`, `equals`, or `HashSet`/`HashMap`?