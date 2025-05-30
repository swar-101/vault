# Subarray Sum Equals K

- **Difficulty:** #medium🟠 
- **Tags:** Array, Hash Table, Prefix Sum

>Problem Description

Given an array of integers nums and an integer k, return *the total number of subarrays whose sum equals to* k.
A subarray is a contiguous **non-empty** sequence of elements within an array.
 
**Example 1:**

> **Input:** nums = [1,1,1], k = 2 
> **Output:** 2

**Example 2:**

> **Input:** nums = [1,2,3], k = 3
> **Output:** 2

 
**Constraints:**

- 1 <= nums.length <= 2 * 10<sup>4</sup>
- -1000 <= nums[i] <= 1000
- -10<sup>7</sup> <= k <= 10<sup>7</sup>

---

## Solution

#### Brute Force Solution

Steps: 
1. Initialize a variable to return the total number of subarrays whose sum is equal to K: `count`
2. Two `for` loops to get each possible subarray.
3. Calculate the sum of these subarrays is equal to k.
4. If k is equal to the sum of the elements in this subarray, increment the `count` by 1.

**Pseudo code:** The two `for` loops 

```java
count = 0;
for (i = 0; i < nums.length; i++) {
	for (j = i; j < nums.length; j++) {
	
	}
}
```


**Dry run:**

nums = [1, 2, 3]
k = 3

| index   | 0   | 1   | 2   |
| ------- | --- | --- | --- |
| element | 1   | 2   | 3   |

| i   | j   | *Subarray* | sum | count |
| --- | --- | ---------- | --- | ----- |
| 0   | 0   | 1          | 1   | 0     |
| 0   | 1   | 1, 2       | 3   | 1     |
| 0   | 2   | 1, 2, 3    | 6   | 1     |
| 1   | 1   | 2          | 2   | 1     |
| 1   | 2   | 2, 3       | 5   | 1     |
| 2   | 2   | 3          | 3   | 2     |


**Pseudo Code:** *Brute Force Implementation*

```java
int count = 0;
for (int i = 0; i < nums.length; i++) {
	int currentSum = 0;
	for (int j = i; j < nums.length; j++) {
		currentSum += nums[j];
		if (currentSum == k) count++
	}
}
return count;
```

#observations👁️

The sum from dry run is nothing but additions of all the previous elements from the array so far until the range changes. 

| Subarray | Sum |
| -------- | --- |
| 1        | 1   |
| 1, 2     | 3   |
| 1, 2, 3  | 6   |
| 2        | 2   |
| 2, 3     | 5   |
| 3        | 3   |

When the range shifts, the excluded indices don't add up to this sum 3 that we want.

So the question is, 
#### *how do I exclude the rest of the indices before the current one, while still finding the number of valid subarrays?*

---
### Optimized Solution 

#intuition💡 

As per #observations👁️  above,
We can deduce that a running sum over all the elements of `nums` is helpful.
Subtracting a previous running sum isolates any subarray.

#### Running Sum

Where, `nums` ranges from i to j,

```
runningSum[j] = nums[i] + nums[i + 1] + ... + nums[j]
```

A subarray sum would be,

```
subSum = runningSum[j] - runningSum[i - 1]
```

> This works because `runingSum[i - 1]` contains all elements before index `i`.

*Example:*

*If `nums = [1, 2, 3]` and `k = 3`:
Let's say we want subarray sum from index 1 to 2.
That means the subarray is `[2, 3]`

*First, let's calculate the prefix sums*

```
runningSum[0] = 1
runningSum[1] = 1 + 2 = 3
runningSum[2] = 1 + 2 + 3 = 6
```

*Therefore,* 
*When `i = 2`,*

```
subSum = runningSum[2] - runningSum[0]
       = 6 - 1
       = 5
```

`sumSum = 5` as expected. 
`[2, 3] -> 2 + 3 = 5` 

#insight💡

We can conclude that `runingSum[i - 1]` enables us to peel off the prefix sum before index `i`,
leaving only subarray sum from `i` to `j`.

 
#observations👁️ 

The running sums of all subarrays will have multiple values. 
At different ranges, the value of running sum can be same.



In order to store these running sums we need a data structure that keeps track of all the running sums so far along with how many times they occur. 
This will ensure that the running sums at each 

Psuedo Code: 

```java

runningSum = 0; 


```




Let's divide this problem in two phases:
1. **Phase 1:** *Prefix Sum Array and sum is equal to k, we increment count*
2. **Phase 2:** *Subtracting `nums` from `prefixSums` elements, to find sum that matches k*


> Phase 1: *Prefix Sum Array and sum is equal to k, we increment count*

 **Pseudo Code:** *Prefix Sum Array and sum is equal to k, we increment count*

```java
int[] prefixSums = new int[nums.length];
prefixSums[0] = nums[0];
for (int i = 1; i < nums.length; i++) {
	prefixSums[i] = prefixSums[i - 1] + a[i];
}
```

**Dry Run:** *Prefix Sum Array and sum is equal to k, we increment count*

k = 3

| index   | 0   | 1   | 2   |
| ------- | --- | --- | --- |
| element | 1   | 2   | 3   |

*Prefix Sum Array*

*1. Initialize first value*

| i   | nums[i] | prefixSums[i] | prefixSums |
| --- | ------- | ------------- | ---------- |
| 0   | 1       | 1             | [1]        |

*2. Loop over `nums`*

| i   | nums[i] | prefixSums[i - 1] + a[i] = prefixSums[i] | count | prefixSums |
| --- | ------- | ---------------------------------------- | ----- | ---------- |
| 1   | 2       | 1 + 2 = 3                                | 1     | [1, 3]     |
| 2   | 3       | 3 + 3 = 6                                | 1     | [1, 3, 6]  |


> **Phase 2:**  *Subtracting `nums` from `prefixSums` elements, to find sum that matches k.*


**Pseudo Code:** *Subtracting `nums` from `prefixSums` elements, to find sum that matches k.* 

```java
for i = 0 to nums.size {
	int currentSum = prefixSums[i] - prefixSums[i - 1]
}
```


**Dry Run:** *Subtracting `nums` from `prefixSums` elements, to find sum that matches k.*

k = 3

nums: 

| index   | 0   | 1   | 2   |
| ------- | --- | --- | --- |
| element | 1   | 2   | 3   |

prefixSums: 

| index   | 0   | 1   | 2   |
| ------- | --- | --- | --- |
| element | 1   | 3   | 6   |

| i   | prefixSums[i] | prefixSum[i - 1] | currentSum | count |
| --- | ------------- | ---------------- | ---------- | ----- |
| 1   | 3             | 1                | 3 - 1 = 2  | 1     |
| 2   | 6             | 3                | 6 - 3 = 3  | 2     |


#edgeCase 
Since, the minimum size of the array can be 1. We write an edge case like:
1. If length is 1, and if the only element is equal to k, we increment and return count.
2. Else, we just return the count as 0;

 ```java
 if (nums.size == 1) 
	if (nums[0] == k) 
		count++
	reutrn 0;
```

**Pseudo Code:** *Optimized using Prefix Sum Technique*

```java
int count = 0; 
int[] prefixSums;
n = nums.size

for 1 to n:
	prefixSums[i] = prefixSums[i - 1] + a[i]
	if (prefixSums == k) count++

if num[0] == k count++;
for 1 to n;
	currentSum = prefixSums[i] - prefixSums[i - 1]
	if (currentSum == k) count++

return count;
```

