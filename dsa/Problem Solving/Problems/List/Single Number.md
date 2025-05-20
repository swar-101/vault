#easy 

Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.

Note: The solution should have a linear time complexity. 

> **Problem Constraints**
> 1 <= |A| <= 200,000
> 0 <= A[i] <= INTMAX


**Input:**
A = [1, 2, 2, 3, 1]

**Output:**
3

**Input:**
A = [1, 2, 2]

**Output:**
1


---

## Solution: 

Since, we need to find the solution with linear time complexity, we need something better than using two loops and comparing each element to find the Single Number.

We can use Bit Manipulation on this array of elements. 

The XOR Bitwise Operator will eliminate all repeating elements.

*For example: 3 ^ 3*
*011 ^ 011*

| 3   | 0 1  1 |
| --- | ------ |
| ^ 3 | 0 1 1  |
| =   | 0 0 0  |

We will simply loop over the array to accumulate XOR operations and the resulting integer would be our non-repeating Single Number.

### Code: 

```java
int singleNumber = 0; 

for (int num : A) {
	singleNumber ^= num; // singleNumber = singleNumber ^ num 
}

return singleNumber;
```



