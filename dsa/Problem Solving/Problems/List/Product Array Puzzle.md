#easy 

Given an array of integers **A**, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.

**Note:** It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.


> **Problem Constraints**

2 <= A.length <= 10<sup>5</sup>
1 <= A[i] <= 10<sup>3</sup>

> **Input**

A = [1, 2, 3, 4, 5]

> **Output**

A = [120, 60, 40, 30, 24]

---

## Solution 

#intuition💡 

Since, we cannot use the division operator, we can exclude the i<sup>th</sup> element and take the product of the rest of the elements.




### Using Prefix Technique to calculate

A = [1, 2, 3, 4, 5]



This product is nothing but, 

`result [i] = product(a[i - 1] ... 0) * product(a[i + 1] ... n)

We can use Prefix Sum Technique to calculate a Prefix Product Array for each i<sup>th</sup> element.
Then we use the same technique to calculate a Suffix Product Array for each i<sup>th</sup> element.

Which is nothing but, 

	`result[i] = prefix[i] * suffix[i]`


Steps: 

1. We simply create a Prefix Product Array for each i<sup>th</sup> by looping over A from left to right
2. We create a Suffix Product Array for each i<sup>th</sup> element by looping over A from right to left
3. We loop over A to store the result for each i<sup>th</sup> element by accessing `prefix[i] * suffix[i]`

A =       [    1,    2,    3,    4,    5]
prefix = [   1,     1,   2,    6,   24]
suffix = [120,  60,  20,    5,    1]
result = [120,  60 , 40,  30,  24]


---0----1---2---3----4
[    1,    2,    3,    4,    5

For the prefix product array...
prefix[0] = 1; 
*since we need to exclude the current position as per our intuition
and there are no prefix elements for 0th position i.e. no elements before 0* 

prefix[1] = a[1 - 1] * prefix [1 - 1];
prefix[2] = a[2 - 1] * prefix [2 - 1];
... 
prefix[i] = a[i - 1] \* prefix[i - 1]; 
	*This enable exclusion of the i<sup>th</sup> element successfully*


For the suffix product array...
----- 0- 1-- 2--3- 4
A = [1,  2,   3,  4,  5]

suffix[4] = 1; 
*since we have to exclude the current position as per our intuition
and there are no suffix elements for the nth postion i.e. no elements after n*

suffix[3] = a[3 + 1] * suffix[3 + 1]
suffix[2] = a[2 + 1] * suffix[2 + 1]
suffix[1] = a[1 + 1] * suffix[1 + 1]
...
suffix[i] = a[i + 1] * suffix[i + 1]



```java
// Prefix Product Array
List<Integer> prefixProductArray = new ArrayList<>();

prefixProductArray.add(1); 
for (int i = 1; i < A.size(); i++) {
	prefixProductArray.add(A.get(i - 1) * prefixProductArray.get(i - 1));
}

// Suffix Product Array
List<Integer> suffixProductArray = new ArrayList<>(Collections.nCopies(A.size(), 1)); 
for (int i = A.size() - 2; i >= 0; i--) {
	suffixProductArray.set(i, A.get(i + 1) * suffixProductArray.get(i + 1));
}

// Final result 
for (int i = 0; i < A.size(); i++) {
	prefixProductArray
		.set(i, prefixProductArray.get(i) * suffixProductArray.get(i));
}

return prefixProductArray;
```




### In-place optimization 

#intuition💡 

As soon as we calculate our suffix value for the i<sup>th</sup> element, we can perform prefix[i] * suffix[i] to get result[i].


Steps:
1. We loop over A to create a Prefix Product Array: result, so that we have prefix product at result[i] for each i<sup>th</sup> element.
2. We loop over A again, but this time from right to left.
3. In this loop, we calculate `result[i] * suffix` for each i<sup>th</sup> element after we accumulate suffix for each i<sup>th</sup> element.
4. For the first index from right, the suffix will be 1, as there are no suffix elements i.e. no elements to its right.


### Code : In-place Optimization

```java
ArrayList<Integer> result = new ArrayList<>();
int prefix = 1;

result.add(prefix); // no actual prefix for idx 0: default = 1
for (int i = 1; i < A.size(); i++) {
	result.add(prefix);
	prefix *= A.get(i - 1); // previous element * prefix product so far
}

int suffix = 1;
for (int i = A.size() - 1; i >= 0; i--) {
	result.set(i, result.get(i) * suffix); // no actual suffix for idx n: default = 1
	suffix *= A.get(i); // current element * suffixProduct so far
}

return result;
```



