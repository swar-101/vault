#medium

Given an array of positive integers **A**, two integers appear only once, and all other integers appear twice.
Find the two integers that appear only once and return them in a descending order.

> Problem Constraints
> 2 < = |A| <= 10<sup>5</sup>
> 1 <= A[i] <= 10<sup>9</sup>

## Solution

### 1. Brute Force: By checking each element with every other element and storing the Single Numbers

This approach is pretty straightforward. 

1. We use two nested loops. 
2. The outer loop iterates over each element and the inner loop presents every other element.
3. We use a `count` variable to store the count.
	- The `count` will be two for the integers that appear twice. 
	- The `count` will be one for the two integers that appear only once.
4. Right after we check each element with the every other element, we get our count.
5. If the `count` is one, we store it in a new array. 
6. We return this new array with the two integers that appear only once. 

### Complexity Analysis: 

- Time Complexity
	O(n<sup>2</sup>) 
		*The nested loops each run n times, resulting in a total of  n * n = n<sup>2</sup> operations. Resulting in quadratic time complexity.*
- Space Complexity
	O(n)
		*We do use another array, although we know for a fact that only a total of two elements will be stored in this array which is constant. Hence, the space complexity is linear.*
		
### Code: 

- Java:

```java
public class SingleNumberIII {

	public ArrayList<Integer> findTwoSingleNumbers(List<Integer> A) {
		
		List<Integer> singleNumbers = new ArrayList<>(); 
		for (int i = 0; i = A.size(); i++) {
			int count = 0;
			for (int j = 0; j = A.size(); j++) {
				if (A.get(i) == A.get(j)) {
					count++; 
				}
			}

			if (count == 1) 
				singleNumbers.add(A.get(i));
		}
		return singleNumbers; 
	}
}
```


---
### 2. Slightly Optimized: Using A Map To Store the frequency

1. We iterate on every element. 
2. We use a Map to store the key as the element and the value as its frequency.
3. After the iteration on every element, we iterate over the Map and return these two integers in a new array.


### Code:

Java: 
v1: Using `HashMap`'s `containsKey()`, slightly convoluted (beginner-friendly).

```java
public class SingleNumberIII {
	public List<Integer> findSingleNumbers(List<Integer> A) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : A) {
			if (frquencyMap.containsKey(num))
				frequencyMap.put(num, frequencyMap.get(num) + 1);
			else 
				frequencyMap.put(num, 1);
		}
	
		List<Integer, Integer> singleNumbers = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			if (entry.getValue() == 1) 
				singleNumbers.add(entry.getKey());
		}
		return singleNumbers;
	}
} 
```

v2: Using `HashMap`'s `getOrDefault()`, better readability. 

```java
public class SingleNumberIII {
	public List<Integer> findSingleNumbers(List<Integer> A) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int num : A) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		List<Integer> singleNumbers = new ArrayList<>(); 
		for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
			if (entry.getValue() == 1) 
				singleNumbers.add(entry.getKey());
		}
		return singleNumbers;
	}
}
``` 

---


### 3. The Fun Way: Using high order functions 

1. We collect the frequencies of all the integers to a Map.
2. We stream this map and filter the integers whose frequency is 1.

### Code: 
Java: 
```java
public class SingleNumbersIII {
	public List<Integer> findSingleNumbers(List<Integer> A) {
		Map<Integer, Integer> frequencyMap = A
			.stream()
			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return frequencyMap.entrySet()
			.stream()
			.filter(entry -> entry.getValue() == 1)
			.map(Map.Entry::getKey)
			.toList();
	}
}
```

Explanation: 
1. `Collectors.groupingBy(Function<? super T, ? extends K> classifier, Collector<? super T,A,D> downstream)` groups by using `Function.identity()` that return the current element and the count is aggragted using `Collectors.counting()` as `frequencyMap`'s key.
  
### Complexity Analysis: 
- Time Complexity
	O(n)
		*1<sup>st</sup> stream : Grouping all the elements. 
		- We loops through all n elements once.
		- HashMap updates and insertions take O(1) average.
		So this step is O(n)*
		*2<sup>nd</sup> stream : Filter + Map
		- We iterate through all unique keys in the map.
		- This full map traversal means n operations
		So this step is O(n)*
		*Since, both of these steps are independent the total number of operations have linear complexity*
		
- Space Complexity
	O(n)
		*`frequencyMap` this maps holds up to n/2 + 2 entries. Since, all the numbers appear twice: n/2 and 2 are unique. This is O(n)*
		*`return List<Integer>` the return statement stores exactly two elements as per the constraint. This is constant.* 
		*Summing up both of these space complexities, we get, O(n) + O(1) = O(n).*
### Complexity Analysis:

- Time Complexity 
	O(n) 
		*There are two loops that run n times. The total number of operations amount to n + n. Hence, the time complexity is linear.*
- Space Complexity
	O(n)
		*Since, we make use of an array which store n number of elements the space complexity is linear.
		The `singleNumbers` array won't affect the space complexity as its size is 2 which is constant for any input n.*

---


### 4. Optimized Solution: Using Bit Manipulations 

*"It's not straightforward, but it's mind-opening and the most efficient."*



A = [1, 2, 3, 1, 2, 5]
#### Step 1:  XOR all the elements to cancel out the integers that appear twice

Let's consider a variable, 
int xor = 0; 

We perform XOR on every element in the array. This XOR operation will cancel out all the integers that appear twice, shown as follows: 

```java
int xor = 0;

for (int num : A) {
	xor ^= num; // xor = xor ^ num; 
}
```

1 ^ 2 ^ 3 ^ 1 ^ 2 ^ 4  = 3 ^ 5 -> 011 ^ 101

  011
  101
=110

Therefore, xor = 110
This implies that the two numbers which appears only once, results to this number.
Here, 3 ^ 5 = 110



---
#blocker 
#### Blocker 1: How can we extract 3 and 5?
Here, we cannot directly extract these two numbers by reversing the Bitwise XOR operation. Simply because, the possibilities of getting the same result with numbers other than 3 and 4 is also possible. 

This basically means, 3 ^ 5 = 110, but we can't say the every 110 comes from only a 3 ^ 5 operation.

#intuition💡
#### The Intuition:  Finding how these two integers are different from each other

Although, we cannot reverse the XOR operation directly to get the two integers that appear only once. We can definitely get some useful information about these two integers. 

3 -> 0 1 1
5 -> 1 0 1 
=     1 1 0

So, what's is the difference between 3 and 5? 
 0 1 1 vs. 1 0 1

1<sup>st</sup> bit from the right is set in both the numbers. 
2<sup>nd</sup> bit from the right is set in 3 and unset in 5. A-ha! This is exactly what separates 3 and 5. 


---
#blocker
#### Blocker 2: How do we check at which position in these two integers the bit is different? 

In the value of the`xor` variable, if the bit at the x<sup>th</sup> position is 1, this means that bit at the x<sup>th</sup> position in these two integers are different. 

There are two ways to get the position at which the rightmost bit is different. 
1. Operating using Left Shift Operation and Bitwise AND operation on 3^5 i.e. `xor`.
2. Using `xor & -xor`. 

#intuition💡 
#### The Intuition: Using Left Shift Operation And Bitwise AND Operation

In order to verify this, we use the Bitwise AND Operation on the `xor` variable. 

And we iterate by shifting a set bit to the left by using the Left Shift Operator until we find the position where the bit is different. 

The loop will something like: 

```java
int diffBit = 1; 
while (xor & diffBit == 0) {
	diff = diff << 1;
}
```

*Let's initialize, 

`diffBit = 1`

The 1<sup>st</sup> operation: 
`xor & diffBit = 6 & 1 = 0110 & 0001`

| variables | values |
| --------- | ------ |
| xor       | 1 1 0  |
| diffBit   | 0 0 1  |
|           |        |
| diffBit   | 0 0 0  |
This means, `xor & diffBit == 0` 

*1<sup>st</sup> iteration*
We do, `diff << 1`
That is, `1 << 1 = 10`


Now, 
`xor = 0110`
`diffBit = 0010`

The 2<sup>nd</sup> Operation: 

`xor & diffBit = 6 & 2 = 110 & 010

| variables | values |
| --------- | ------ |
| xor       | 1 1 0  |
| diffBit   | 0 1 0  |
|           |        |
| diffBit   | 0 1 0  |

Now, 

`diffBit << 1 = 010 << 1 = 100`


The 3<sup>rd</sup> Operation

| variables | values |
| --------- | ------ |
| xor       | 1 1 0  |
| diffBit   | 1 0 0  |
|           |        |
| diffBit   | 1 0 0  |



We found the right most position at which the bit is different. 


#techinque💪

### The Technique: 

### Step 3:  Getting the two integers by splitting and conquering 

We iterate over all elements once again to check if the Bitwise AND Operation between each element and this `diffBit` variable is either 0 or 1. 


3 ->           0 1 1 
diffBit ->   0 1 0 
 =              0 1 0


5 ->        1 0 1 
diffBit -> 0 1 0
=             0 0 0 


1, 2, 3, 2, 1, 5

1  ^ 0 = 1
10 

```java
for (int num : A) {
	if (num & diffbit == 0) {
		a = a ^ num; 	
	} else {
		b = b ^ num; 
	}
}

return a < b ? {a, b} : {b, a}; 
```




## Final Code: 

Java: 

1. 
```java
public class SingleNumber {
	public ArrayList<Integer> findTwoSingleNumbers(ArrayList<Integer> A) {
		int xor = 0; 
		for (int num : A) {
			xor ^= num;
		}

		int diffBit = 1; 
		while (xor & diffBit == 0) {
			diffBit = xor & diffBit;
		}

		int a, b = 0; 
		for (int num : A) {
			if (xor & diffBit == 1)
				a ^= num;  
			else 
				b ^= num;
		}

		return (a < b) ? {a, b} : {b, a};
	}
}
```





