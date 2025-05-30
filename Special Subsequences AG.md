Given a string A having Uppercase English Letters.
You have to find the number of pairs (i, j) such that A[i] = 'A', A[j] = 'G' and i < j.


**Problem Constraints**  

1 <= length(A) <= 10<sup>5</sup>

**Input Format**  

First and only argument is a string A.
  
**Output Format**  

Return an long integer denoting the answer.

---

Example: 

A = "ABCGAGA"
Output: 3

Explanation: 

There are three pairs in this [[Subsequence]].
0  1   2  3  4   5  6 
A  B  C  G  A  G  A

0 3
0 5
4 5

The key is count AG pairs as we loop through all the character in the array. 
Let's iterate this string and see how we can find all the pairs.

1. We check if the current character is A, if it's true, we increment A count by 1.
2. We check if the current character is G, it's true, we increment AG count.

| i   | s.charAt(i) | countA | countAG = countAG + countA |
| --- | ----------- | ------ | -------------------------- |
| 0   | A           | 1      | 0                          |
| 1   | B           | 1      | 0                          |
| 2   | C           | 1      | 0                          |
| 3   | G           | 1      | 0 + 1  = 1                 |
| 4   | A           | 2      | 1                          |
| 5   | G           | 2      | 1 + 2 = 3                  |
| 6   | A           | 3      | 3                          |

## Code: 

Java: 

```java

public int countAG(String s) {
	int countA = 0;
	int countAG = 0;

	for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i) == 'A')
			countA++;
		if (s.charAt(i) == 'G')
			countAG += countA; // countAG = countAG + countA
	}
	return countAG;
}
```


#insight💡  
Notice how we don’t explicitly store the count of `'G'` characters.  
Instead, we accumulate the result directly in `countAG` every time we encounter a `'G'`, by adding the number of `'A'`s seen so far.  
This eliminates the need for extra tracking variables like `countG`, keeping our solution clean and space-efficient.


## Complexity Analysis

### Time Complexity

Since, we find the count of all the pairs in one pass. 
We perform N number of operations for a string of length N.
This means our algorithm runs in linear time i.e. $$O(N)$$
### Space Complexity

We only use a few integer variables `aCount`, `agCount`, so our algorithm uses constant space i.e. $$O(1)$$

