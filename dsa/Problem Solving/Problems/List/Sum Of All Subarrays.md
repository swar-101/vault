#easy 


You are given an integer array **A** of length **N.**  
You have to find the sum of all subarray sums of A.  
More formally, a subarray is defined as a contiguous part of an array which we can obtain by deleting zero or more elements from either end of the array.  
A subarray sum denotes the sum of all the elements of that subarray.

**Note :** Be careful of integer overflow issues while calculations. Use appropriate datatypes.

> **Problem Constraints**

1 <= N < 10<sup>5</sup>
1 <= A[i] <= 10<sup>4</sup>


> **Input**

A = [1, 2, 3]

> **Output**

20

---
## Solution 

= 6 + 5 + 3 + 1 + 2 + 3

[1], [2], [3], [1, 2], [2, 3], []


[1, 2, 3]
-> 
[1]
[1, 2]
[1, 2, 3]
[2]
[1, 2]
[2, 3]
[1]



```java

for (int i = 0; i < A.size(); i++) {
	for (int j = 0; j < A.size() - i; j++) {
		for (int k = 0; k < A.size(); k++) {
			sum += a[k];	
		}	
		sum += a[j];			
	}
}
```

| i | j | a[j] | currentSum | total               |
|---|---|------|------------|---------------------|
| 0 | 0 | 1    | 1          | 1                   |
| 0 | 1 | 2    | 1 + 2      | 1 + 3               |
| 0 | 2 | 3    | 1 + 2 + 3  | 1 + 3 + 6           |
| 1 | 1 | 2    | 2          | 1 + 3 + 6 + 2       |
| 1 | 2 | 3    | 2 + 3      | 1 + 3 + 6 + 2 + 5   |
| 2 | 2 | 3    | 3          | 1 + 3 + 6 + 2 + 5 + 3 |




