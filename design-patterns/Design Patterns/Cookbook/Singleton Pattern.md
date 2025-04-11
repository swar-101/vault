
# Singleton Pattern Cookbook

For Single-threaded Environment
 - [Lazy Initialization](#lazy-initialization)
 - [Eager initialization](#eager-initialization) *(not recommended)*

For Multithreaded Environment 
- [Using `synchronized` block](#using-synchronized-keyword)
- [Using Double-checked locking](#using-double-checked-locking) *(best practice)*

Miscellaneous 
- [The Bill Pugh Singleton](#the-bill-pugh-singleton) *(best practice)*


## For Single-threaded Environments 

## 1. [[Lazy Initialization]]

1. **Initializing Singleton Instance:** Create a private static global instance of the object inside the intended class. Initialize it to null. Name it as "INSTANCE" as a good practice.  
```java
public static FooBar INSTANCE = null;
```

This is going to be our Singleton Instance after further processing.
    
2. **Creating Private Constructor:**  
    Create a private constructor for instantiating this Singleton Instance. Choose a parameterized or a non-parameterized constructor depending on whether the instance requires additional parameters to ensure appropriate instantiation of this Singleton Instance.  
    This private constructor creation will prevent external instantiation, ensuring that it is possible instantiating the Singleton Instance in the intended class only.
    
3. **Creating `getInstance()` Method:**  
    Create a method named `getInstance()` with the return type set to Singleton Class. This method will return the Singleton Object which will be used globally.  
    In this method, we ensure that the Singleton Instance is only instantiated if and only if it is null.  
    It also ensures that our Singleton Instance is instantiated only once throughout the lifecycle of our program.
    
4. **Creating `resetInstance()` Method (Note: Not for Production Use):**  
    Create a method name `resetInstance` with return type void. This method will set our instantiated Singleton Instance to null.  
    This is especially useful in non-production environments during testing as it provides control to reset our instantiated Singleton Instance on demand.  
    Note: Make sure you exclude this from Production Code as it breaks the Singleton guarantee.
    

---

## 2. [[Eager Initialization]] 
Not recommended

1. **Creating a Private Constructor:**  
    Create a private constructor for instantiating this Singleton Instance. Choose a parameterized or a non-parameterized constructor depending on whether the instance requires additional parameters to ensure appropriate instantiation of this Singleton Instance.
    
    **In case of a non-parameterized constructor requirement:**
    
    ```java
    	private FooBar() {}
    ```
    
    **In case of a parameterized constructor requirement:**
    
    ```java
    	private int foo;
    	private String bar;
    
    	private FooBar(int foo, String bar) {
    		this.foo = foo;
    		this.bar = bar;
    	}
    	
    ```
    
    This private constructor creation will prevent external instantiation, ensuring that it is possible instantiating the Singleton Instance in the intended class only.
    
2. **Instantiating Singleton Instance:**  
    Create a private static final global instance of the object inside the intended class. Instantiate using the `new` keyword with the help of our newly created Private Constructor from Step 1. Name it as "INSTANCE" as a good practice.
    
    **In case of a non-parameterized instantiation requirement:**
    
    ```java
    public static final FooBar INSTANCE = new FooBar();
    ```
    
    **In case of a paramterized instantiation requirement:**
    
    ```java
    // Note: foo, bar are already declared in step 1
    public static final Foobar INSTANCE = new FooBar(foo, bar);
    ```
    
    This is going to be our final instantiation of the Singleton Instance.  
    This simple instantiation will ensure that the instance is created as soon as the class is loaded by the compiler.  
    This will also make the Singleton Instance thread-safe as it will be instantiated instantly into the static memory.
    
3. **Creating `getInstance()` Method:**  
    Create a method named `getInstance()` with the return type set to Singleton Class.  
    As shown below:
    
    ```java
    public static FooBar getInstance() {
    	return INSTANCE;
    }
    ```
    
    This method will simple return the already instantiated Singleton Instance from Step 2.
    
4. **Creating `resetInstance()` Method (Note: Not for Production Use):**  
    Create a method name `resetInstance` with return type void. This method will set our instantiated Singleton Instance to null.
    
    ```java
    public static void resetInstance() {
    	INSTANCE = null;
    }
    ```
    
    This is especially useful in non-production environments during testing as it provides control to reset our instantiated Singleton Instance on demand.  
    Note: Make sure you exclude this from Production Code as it breaks the Singleton guarantee.
    

---

## [Why is Eager Loading in singleton-threaded environment not recommended?](#why-is-eager-loading-in-singleton-threaded-environment-not-recommended)


1. **Memory Overhead:**  
    *What if we never end up using this Singleton Instance?* 
    It would seem unnecessary to instantiate it as soon as the class load into the compiler.  
    *What if this Singleton Instance is resource-intensive?* 
    Loading a heavy Singleton Instance object without its use leads to unnecessary memory usage.
    
2. **Lack of Flexibility:**  
    We don't get the control of instantiating it ourselves. We just end up calling the Singleton Instance "INSTANCE" which is already instantiated for us.
    
3. **Thread-safety is Overkill:**  
    We have a single-threaded environment, having a thread-safe instance would seem a good idea at first.  
    *"But do we really need a thread-safe instantiation of a resource-intensive Singleton Instance which causes memory overhead and we never or rarely use it?"*
      
    Thread-safety isn't a primary concern when it comes to single-threaded environments.  
    It's nice to have thread-safety if you expect that your code might evolve into a multithreaded environment.
    


## For Multithreaded Environments

### Using `synchronized` keyword
	
1. **Initializing Singleton Instance:** Create a private static global instance of the object inside the intended class. Initialize it to null. Name it as "INSTANCE" as a good practice.  
```java
public static FooBar INSTANCE = null;
```

> This is going to be our Singleton Instance after further processing.
    
2. **Creating Private Constructor:**  
    Create a private constructor for instantiating this Singleton Instance. Choose a parameterized or a non-parameterized constructor depending on whether the instance requires additional parameters to ensure appropriate instantiation of this Singleton Instance.  
    
> This private constructor creation will prevent external instantiation, ensuring that it is possible instantiating the Singleton Instance in the intended class only.

3. Create `getInstance()` method:
	Create a method called `getInstance()`. This method will instantiate our Singleton Instance in a `synchronized` block if null or return a Singleton Instance of the class if already instantiated. 
	
```java
public static FooBar getInstance() {
	if (INSTANCE == null) {
		synchronized ()
	}
	return INSTANCE;
}
```

> This ensures that the Singleton Instance is created in a [[non-blocking]] manner. 
> In multithreaded environments, it's possible that the `getInstance()` method is called concurrently (at the same time) during execution. The `synchronized` keyword ensures thread-safety by locking the process until the Singleton instance is ready to use. 

4. **Creating `resetInstance()` Method (Note: Not for Production Use):**  
    Create a method name `resetInstance` with return type void. This method will set our instantiated Singleton Instance to null.
    
    ```java
    public static void resetInstance() {
    	INSTANCE = null;
    }
    ```
    
> This is especially useful in non-production environments during testing as it provides control to reset our instantiated Singleton Instance on demand. 

> Note: Make sure you exclude this from Production Code as it breaks the Singleton guarantee.


