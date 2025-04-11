# Copying Objects in Java

When copying objects in Java, we need consider how the internal fields are copied. 

**The difference between shallow and deep copy determines whether changes in the original object affects the copied object.**

---
## 1. What is a Shallow Copy?

A shallow copy creates a new object, but copies the references of mutable fields instead of duplicating them. 


As a result, changes in the original object's mutable fields affect the copy.

```java
public class ShallowPerson {

	public String name; 
	public int age;
	public List<String> hobbies;

	public ShallowPerson(String name, int age, List<String> hobbies) {
		this.name = name;
		this.age = age;
		this.hobbies = hobbies;
	}

	// Copy Constructor
	public ShallowPerson(ShallowPerson copy) {
		this.name = copy.name;
		this.age = copy.age;
		this.hobbies = copy.hobbies;
	}
}

public class Application {

	public static void main(String[] args) {
		List<String> hobbies = new ArrayList<>();
		hobbies.add("Reading");
		
		ShallowPerson original = new ShallowPerson("Alice", 10, hobbies);
		ShallowPerson shallowCopy = new ShallowPerson(original); // shallow copy 

		shallowCopy.hobbies.add("Gaming");  // Modifies `original` too! 

		System.out.println(original.hobbies);        // ["Reading", "Gaming"]
		System.out.println(shallowCopy.hobbies);     // ["Reading", "Gaming"]
	}
}
```

---

## 2. What is Deep Copy?

A deep copy creates a new object, and also creates a new copies of any mutable fields.
This means, each mutable field will have a separate, independent reference.


```java
public class DeepPerson {
	public String name;
	public int age;
	public List<String> hobbies;

	public DeepPerson(String name, int age, List<String> hobbies) {
		this.name = name;
		this.age = age;
		this.hobbies = hobbies;
	}

	// Copy Constructor
	public DeepPerson(DeepPerson copy) {
		this.name = copy.name;
		this.age = copy.age;
		this.hobbies = new ArrayList<>(copy.hobbies); // creates a deep copy
	}
}

public class Application {

	public static void main(String[] args) {
		List<String> hobbies = new ArrayList<>();
		hobbies.add("Reading");
		
		DeepPerson original = new DeepPerson("Alice", 10, hobbies);
		DeepPerson deepCopy = new DeepPerson(original);

		deepCopy.hobbies.add("Gaming"); // Only modifies the `deepCopy`

		System.out.println(original.hobbies);           // ["Reading"]
		System.out.println(deepCopy.hobbies);           // ["Reading", "Gaming"]
	}
}
```


---



