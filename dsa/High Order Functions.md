# High Order Functions 

Functions that take other functions as arguments or return functions as results. 

Why do they matter? 
They allow us to: 
	1. Abstract behavior
	2. Create Flexible APIs
	3. Write more concise code

These are the key functional programming constructs which help creating high order functions:

1. Lambda Expressions
2. Method References
3. Function Pipelines
4. Grouping and Aggregation
5. Flat Map and Reduction
6. Predicate Functions


# 1. Lambda Expressions 

Anonymous, inline functions that allow you to pass behavior as data.

Why do they matter? 
They simply code and make it more expressive.


**Examples:** 

1. Java 
	
	```java
	List<Integer> numbers = List.of(1, 3, 5, 2, 5);
	List<Integer> doubled = numbers.stream().
			.map(number -> number*2)
			.toList();
	```

2. C++: 
> using `std::transform`

3. Python:
> Using `lambda`


4. JavaScript:
> Arrow Functions 


5. Golang: 
> Anonymous Functions 


# 2. Method References

A shorthand notation to refer to a method without invoking it. 

**Why do they matter?** 
They 
- improve code readability and 
- reduce boilerplate code.


**Example:**

Instead of writing, 

```java
n -> n.toString()
```

you can write: 

```java
Object::toString
```


# 3. Functional Pipelines

A series of operations performed on a collection to transform and produce a result.

**Why do they matter?** 


**Phases:** 
1. Sequencing: 
	Converting a collection into a stream. 
	#analogy *Think of this as laying out your raw ingredients.*

2. Intermediate Operations: 
	Transformations like `map()`, `filter()` and `flatMap()`.
	 #analogy *These are like the steps in a recipe (chopping, blending, etc.)*.

3. Terminal Operations: 
	Operation like `collect()`, `reduce()` and `forEach()` that produce the final output. 
	#analogy *This is the finished dish.*


Examples: 
1. Java
2. C++
3. JavaScript
4. Python 
5. Golang 


# 4. Grouping and Aggregation

**Concepts:**
- Classifier Function: 
		A function that determines how to group items.
- Downstream Collector: 
		A collector that processes each group, such as counting or summing values. 
	

Why do they matter? 
They allow you to organize data efficiently.




**Examples:**

1. **Java:**  
    _Imagine you're writing code for a Parking Lot System._  
    _The Parking Lot is composed of many floors._  
    _Each floor has many parking spots._  
    _Let's take a look at what the `ParkingFloor` class is made of..._
    
    ![[high-order-functions-grouping-and-aggregation-example-parking-lot.png]]
    
    _The goal is to find all the Parking Spots that are `AVAILABLE` for each Vehicle Type on a particular Parking Floor to ensure that new vehicles are ready to be onboarded to this Parking Floor._  
    _Let's assume this particular Parking Floor is retrieved from the Database and our goal is to meet the above requirements._
    
    **Solution:**  
    Let's list down the requirements:
    
    1. The Parking Spot should be `AVAILABLE`.
    2. We need to keep count of each Parking Spot which is `AVAILABLE`.
    3. We need to keep count of each `AVAILABLE` Parking Spot for each `VehicleType`.

    In order to keep track of each available Parking Spot and group them according to their Vehicle Type, we will need a Map. This Map will store `VehicleType` as the key and the number of spots available as its value. Let's write down the steps briefly.
    
1. **Instantiate a Map** with `VehicleType` as key and `Integer` to store its corresponding value.
        
	```java
	Map<VehicleType, Integer> availableParkingSpots = new HashMap<>();
	```
	
2. **Check the Parking Floor Status:**  
        Before sequencing, we need to ensure that the `ParkingFloorStatus` is `OPERATIONAL`. This ensures that we stream this `parkingFloor` only if it's operational, otherwise it may yield a false positive resulting in mismanagement of the Parking Lot System.
        
	```java
	if (parkingFloor.getParkingFloorStatus().equals(ParkingFloorStatus.OPERATIONAL)) {
		// .. 
	}
	```
        
3. **Sequence the Parking Spots:**  
        Get the list of Parking Spots associated with this parking floor.
        
	```java
        List<ParkingSpot> parkingSpots = parkingFloor.getParkingSpots();
        ```
        
4. **Group and Aggregate the Available Parking Spots:**  
        Use the `parkingSpots` list to group and aggregate the available parking spots into a Map (`availableParkingSpots`).
	
	```java
	availableParkingSpots = parkingSpots
		.stream()
		.filter(parkingSpot -> parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE))
		.collect(Collectors.groupingBy(
			spot -> spot.getVehicleType(), 
			Collectors.summingInt(spot -> 1)
		));
	```

	- `stream()` - Initiates sequencing by streaming each Parking Spot one by one.
	- `filter(parkingSpot -> parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE))` - Streams only the elements whose Parking Spot Status is `AVAILABLE`. 
	- `collect(Collectors.groupingBy(spot -> spot.getVehicleType(), Collectors.summingInt(spot -> 1)))` - Aggregates all the available spots and group them according to their corresponding Vehicle Type. 
	- `Collectors.groupingBy(spot -> spot.getVehicleType())` - A Classifier Function that determines the grouping based on Vehicle Type.
	- `Collectors.summingInt(spot -> 1)` - A Downstream Collector that processes each group. Passing `spot -> 1` means that for each available spot , produce the integer 1; summing these gives the count of spots. 



# 5. FlatMap and Reduction

- **FlatMap**
	- Flattens a stream of collections into a single stream
	#analogy *Emptying several toy boxes so that you can see all the toys at once.*

- Java Example: 
	```java
	
```

- Reduction 
	- Combining elements of a stream into a single result, like summing numbers.

- Java Example


# 6. Predicate Functions

- Definition 
	- Function that returns a Boolean value (true/false) used to test conditions.

- Why they matter? 
	- They form a basis of filtering in streams


Example:

```java
boolean isEven = (n) -> n % 2 == 0;
```

#analogy *A yes or no question that decides something belongs in a group.*


