#easy

You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.

Note : Matrices are of same size means the number of row and columns in both the matrices are equal.


![[Pasted image 20250520160620.png]]

> **Problem Constraints**

`1 <= A.size()`
`B.size() <= 1000`
`1 <= A[i].size(), B[i]size() <= 1000`

> **Input**

`A = [[1, 2, 3],
`    [4, 5, 6],
`    [7, 8, 9]]`

`B = [[9, 8, 7],
 `    [6, 5, 4],
`    [7, 8, 9]]`

> **Output**

```
[[10, 10, 10],
[10, 10, 10],
[10, 10, 10]]
```

---

### Solution 

Steps: 

1. We use two for loop to locate each cell in both A and B whose size is equal.
2. We add `A[i][j]` and `B[i][j]` and either store it in a new array or use matrix A to store the resulting sums of the elements.


```java
for (int i = 0; i < A.size(); i++) {
	for (int j = 0; j < A.get(i).size(); j++) {
		A.get(i).set(j, A.get(i).get(j) + B.get(i).get(j));
	}
}

return A;
```