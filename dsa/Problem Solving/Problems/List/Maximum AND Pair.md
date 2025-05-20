Given an array A. For every pair of indices i and j (i != j), find the maximum A[i] & A[j]




> Problem Constraints: 
> 1 <= len(A) <= 10<sup>5</sup>
> 1 <= A[i] <= 10<sup>9</sup>



### Brute Force

Dry Run: 
[38, 44, 84, 12]

38 44
38 84 
38 12

44 84
44 12

84 12


Pseudo Code
```java
maxAnd = -1;

if (A.size() == 2) {
		return A.get(0) & A.get(1);
}
for (int i = 0; i < A.size(); i++) {
	
	for (int j = i + 1; j < A.size(); j++) {
		int result = A.get(i) & A.get(j);
		int maxAnd = Math.max(maxAnd, result);
	}
	
	return maxAnd;
}

```

### ⚠️ This would throw TLE (Time Limit Exceeded)

Why? 
Because the problem constraints state that the size of the array could be as large as 1,00,000 i.e. 10<sup>5</sup>. 
We need an efficient solution. This is a good starting point, there's a better way. 
We need a [[Greedy Approach]].


### Slightly Optimized: Sorting the array and iterating the array from right to left

We should understand that the bigger the numbers are the probability of its AND operation resulting in bigger results is more.

1. We sort the array. So that the bigger numbers end up in the right and smaller ones follow towards left. Why? The bigger numbers share more high bits. 
   *Example: 
	3 & 38 -> -000011 & 100110
		The rightmost bits of three would result is a less larger number.
		On the other hand,
	30 & 38 -> 11110 & 100110
		The rightmost bits of thirty would result in a high number. *



3. We iterate from right to left and perform AND operation on each element. 

Dry Run


Code: 
```java

int maxAnd = -1;

// Our edge will still persist
if (A.size() == 2) return A.get(0) & A.get(1);

Collections.sort(A);

for (int i = A.size() - 1; i > 0; i--) {
	int result = A.get(i) & A.get(i - 1);
}

```


Dry Run: 

[38, 44, 84, 12]
After sorting,
[12, 38, 44, 84]

| i   | A[i] | i - 1 | A[i -1] |
| --- | ---- | ----- | ------- |
| 3   | 84   | 2     | 44      |
| 2   | 44   | 1     | 38      |
| 1   | 38   | 0     | 12      |
Note: This approach won't compare all the elements, so it's a heuristic solution and not proof-backed. It will work for most practical cases, but can fail in some scenarios. 

It's safe to say, it's not the best way to optimize. Let's move to the best approach.


### Optimized Solution: Using [[Bitmasking]]

Core Idea: 
We try to build the solution bit by bit, from the most significant bit (MSB) to the least significant bit (LSB).

At each step we check if there are at least two numbers in the array whose AND operation with this guess is a match. 

If yes, keep the bit which is a match in the answer. 
If not, clear the bit and move to the next bit. 


Why? 

Because, AND Operation is all about matching bits, if the bits in the two integers are set, the bit in the answer is set: `1 & 1 == 1`.


Let's say we have: 

A = [38, 30, 15]

38 -> 100110
30 -> 011110 
15 -> 001111


We initialize, 
`int maxAnd = 0;`


The problem constraint states that the element can be as large as 10<sup>9</sup>  i.e. 10,00,00,00,00.

We'll loop from 31 to 0.

```java
int maxAnd = 0; 
for (int bit = 31; bit >= 0; bit--) {
	int candidate = maxAnd | (1 << bit);
	int count = 0; 

	for (int num : A) {
		if ((num & candidate) == candidate) {
			count++;
		}
		if (count >= 2) break;
	}

	if (count >= 2) {
		maxAnd = candidate;
	}
}
return maxAnd;
```




