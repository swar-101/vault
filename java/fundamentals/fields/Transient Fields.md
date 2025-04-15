# Transient Fields 

Transient fields are marking with [[The `transient` keyword]] keyword, meaning they should be skipped during [[Serialization]]. 

- [[Lombok]] also skips these fields in `equals()` and `hashCode()` as often they're non-essential.

Example: 

```java
class User {
	transient token;
}
```

