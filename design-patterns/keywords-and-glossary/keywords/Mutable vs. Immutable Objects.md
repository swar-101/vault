
#analogy 
# Box 📦

Think of an object like a Box. 

Immutable:
Once sealed, you can't change what's inside. You must only replace it with a new box.

Mutable: 
You can open it and modify its contents without replacing the box.

---
## Immutable Objects

The object which cannot be changed after creation are Immutable Objects.

- Primitives: `int`, `float`, `double`, `boolean`, etc.  *Because they hold values, not references.*
- String: The Java String are Immutable. *Any modification creates a new object.*
- Wrapper classes: `Integer`, `Float`, `Double`, `Boolean` 


## Mutable Objects

- Objects with fields that change: `ArrayList`, `HashMap`, `StringBuilder`, custom classes.
- Collections: Even if they contain Immutable Objects (like `List<String>`), the collection itself is mutable.

---

### *Let's understand this through an example...*

#### Using String

```java
String s1 = "Hola";         // s1 is a new object
String s2 = s1.concat(" mundo");  // s2 is a new object
System.out.println(s1);    // "Hola"
System.out.println(s2);;   // s2 is a new object with value "Hola mundo"
```

`String` is Immutable.
💡 Why? The original string `s1` doesn't change;  a new one `s2` is created.

#### Using StringBuilder

```java
StringBuilder sb = new StringBuilder("Hola"); // sb is our new object
sb.append(" mundo");    // Modifies current object sb
System.out.println(sb); // "Hola mundo"
```

`StringBuilder` is Mutable.
💡Why? The same object is modified saving memory.

---

