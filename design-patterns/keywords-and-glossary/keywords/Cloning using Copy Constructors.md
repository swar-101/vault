
# Achieving Prototype Pattern using [[Copy Constructor]]


- [[Copy Constructor]]
- [[Mutable vs. Immutable Objects]]


1. Creating a [[Copy Constructor]]:
	Create a Copy Constructor, which takes in the class itself as the parameter. This constructor assigns each field of this parameter to the class-level fields.   


In case of achieving a shallow clone we create a Shallow Copy Constructor:

```java
public class FooBar {

	String field1;      
	int field2;
	List<String> field3;

	// Copy constructor
	public FooBar(FooBar clone) {
		this.field1 = clone.field1;
		this.field2 = clone.field2;
		this.field3 = clone.field3;  
	}
}
```

Since, `field1` is an Immutable Object and `field2` is a primitive value type shallow copies are enough to clone them entirely.
However, `field3` is a Mutable Object which means the clone will share its reference with the original object. 

In case of achieving a deep clone we create a Deep Copy Constructor:

```java
public class FooBar {

	String field1; 
	int field2;
	List<String> field3;

	public FooBar(FooBar clone) {
		this.field1 = clone.field1;
		this.field2 = clone.field2;
		this.field3 = new ArrayList<>(clone.field3);
	}
}
```

2.  



















```java
public class GameUnit implements Cloneable {
	protected String type;
	public abstract void attack();

	public GameUnit() {
		try {
			return (GameUnit) super.clone();
		} catch {
			throw new AssertionError();	
		}
	}
}

class Soldier extends GameUnit {

	public Soldier() {
		this.type = "Soldier";
	}

	public void attack() {
		System.out.println(type + "attacks!");
	}
}

public class Game {

	public static void main(String[] main) {
		Soldier soldierPrototype = new Soldier();
		Soldier 
	}
}
```


2. 