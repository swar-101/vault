Given an array A of length N, your task is to find the **maximum possible sum** of any **non-empty contiguous subarray**.

> **Problem Constraint:**
> 1 <= N <= 10<sup>6</sup>
> -1000 <= A[i] <= 1000


**Input**
A = [1, 2, 3, 4, -10]

**Output**
10

--- 
## Solution

#### Brute Force: 

1. We loop over the array using two pointers.
2. These two pointers are going to be our sliding window. 
3. We'll have a global max and a local max.


```java
int globalMax = A.get(0);
int localMax = A.get(0);
for (int i = 1; i < A.size(); i++) {
	localMax = Math.max(A.get(i), localMax + A.get(i));
	globalMax = Math.max(localMax, globalMax);
}
return globalMax;
```


[1, 2, 3, 4, -10]

| i   | A[i] | localMax | globalMax |
| --- | ---- | -------- | --------- |
| 0   | 1    | 1        | 1         |
| 1   | 2    | 3        | 3         |
| 2   | 3    | 6        | 6         |
| 3   | 4    | 10       | 10        |
| 4   | -10  | 0        | 10        |


