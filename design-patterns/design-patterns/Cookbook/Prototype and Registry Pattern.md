Prototype and Registry Cookbook:

Prototype:

1. Ensure that you have implemented the intended class with Cloneable interface.
2. Override the `clone()` method provided by the Cloneable interface.
3. Use this method to a deep copy of the intended class.
	3.1. If it's an immutable object like String, enum, etc., using `clone()` method will clone the fields with these Data Types.
	3.2. If it's a mutable object like a collection, etc, we need to iterate through each element and ensure that each element is cloned from these collection, creating a deep copy.
4. In case of primitive types, `clone()` method is enough prototype the attributes with these Data Types.
5. In case of nested objects, we need to ensure that either 
		- these nested objects implement the Cloneable interface, or
		- the intended class uses `clone()` to create deep copies by using step no. 3.


Registry:

1. Create a registry interface for implementing a registry class, ideally by appending the name of the intended class with the keyword `Registry`.
	For example, if the name of the class is `FooBar` the name of its registry interface would be `FooBarRegistry` and its implmenting class would be `FooBarRegistryImpl`.	
2. This registry interface should have methods for adding, removing and getting prototypes. 



Ensure that all possibilities of getting a `NullPointerException` are handled.




















# Registry and Prototype Cookbook


For creating Prototype Pattern, there are two alternatives to choose from:
1. [[Cloning using Copy Constructors]]
2. [[Cloning using the Cloneable interface.]]

Additionally, 
There is a case where [[Shallow Copies]] are enough for prototyping.





