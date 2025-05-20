You are given an Matrix A and an integer B, you have to perform scalar multiplication of matrix A with an integer B.

> **Problem Constraints**

`1 <= A.size() <= 1000`
`1 <= A[i].size() <= 1000`
`1 <= A[i][j] < = 1000`

> **Input**

`A = [[1, 2, 3],
`	[4, 5, 6], 
`	[7, 8, 9]]`

B = 2

> **Output**

`A = [[2, 4, 6],
`	[8, 10, 12], 
`	[14, 16, 18]]`


---

### Solution

Steps:

1. We loop over the rows of the matrix.
2. Then we loop over the column to get hold of each cell.
3. We multiply this element with B and store it in the same position.
4. Return the 2D matrix.



```java

for (int i = 0; i < A.size(); i++) {
	for (int j = 0; j < A.get(i).size(); j++) {
		A.get(i).set(j, A.get(i).get(j) * B);
	}
}

return A;
```

