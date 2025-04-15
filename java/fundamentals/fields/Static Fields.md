# Static Fields 

Static fields belong to the class, not the object.

- They're shared across all instances.


The Lombok's [[@EqualsAndHashCode]] ignores them because equality of objects shouldn't depend on class-level properties.

Example: 

```java
class User {
	static int userCount;
}
```


