## Before you dive in...

You must know:
- [[Mutable vs. Immutable Objects]]
- [[Shallow Copy vs. Deep Copy]]

---
# Copy Constructor 

#analogy 
# Photocopying a Notebook

Imagine you have a notebook filled with notes. 📒
You want to share this with a friend. 🧑‍🦰

There are two ways:
- Shallow Copy : You hand over the same notebook.
- Deep Copy: You rewrite every page into a new notebook. 

A Copy Constructor let's you create such copy in Java.

---

## 1. Shallow Copy
## Example:

`String` is Immutable, therefore creating a shallow copy makes sense.


```java
public class Notebook {
	private String subject;

	public Notebook(String subject) {
		this.subject = subject;
	}

	// Copy Constructor (Shallow copy) 
	public Notebook(Notebook copyNotebook) {
		this.subject = copyNotebook.subject;
	}
}


public class Application {
	public static void main(String[] args) {
		Notebook original = new Notebook("Math");
		Notebook copy = new Notebook(original);

		System.out.println(original);   // "Math"
		System.out.println(copy);       // "Math"
	}
}
```


--- 

## 2. Deep Copy

### Example:

`String` is Immutable, therefore creating a shallow copy is enough.
`List<String>` is a collection of `String`, therefore we need create a deep copy for this field.

```java
public class Notebook {
	private String subject;
	private List<String> notes;

	public Notebook(String subject, List<String> notes) {
		this.subject = subject;
		this.notes = notes;
	}

	// Copy Constructor
	public Notebook(Notebook copyNotebook) {
		this.subject = copyNotebook.subject;
		this.notes = new ArrayList<>(copyNotebook.notes); // Creates a deep copy
	}
}

public class Application {

	public static void main(String[] args) {
		List<String> notes = new ArrayList<>();
		notes.add("Chapter 1: Functions");

		Notebook original = new Notebook("Math", notes);
		Notebook copy = new Notebook(original);

		original.add("Chapter 2: Derivatives");

		System.out.println(original.notes); // Has both Chapter 1 and Chapter 2
		System.out.println(copy.notes);     // Has only Chapter 1
		
	}
}
```

💡Key Observation:
- Deep copy ensures the copied object is independent.


