#easy

You are given two matrices **A** and **B** of equal dimensions and you have to check whether two matrices are **equal or not**.

Note: Both Matrices are equal if `A[i][j] == B[i][j]` for all i and j. 

> **Problem Constraints**

`1 <= A.size, B.size <= 1000`
`1 <= A[i].size(), B[i].size() <= 1000`
`1 <= A[i][j], B[i][j] <= 1000`
`A.size() == B.size()`
`A[i].size() == B[i].size()`


> **Input**

`A = [[1, 2, 3],
`    [4, 5, 6], `
`    [7, 8, 9]]

`B = [[1, 2, 3],
`    [4, 5, 6],
`    [7, 8, 9]]`

> **Output**

1

--- 

### Solution


#intuition💡 

Although the size of matrices is equal, this doesn't mean they are square matrices.
As soon as we find the element at a particular cell isn't equal, we return 0.


Steps: 
1. We use two loops to locate cell position in both A and B.
2. We compare the element at this position.
3. If it's equal, we move on, if not, we return 0.

```java
for (int i = 0; i < A.size(); i++) {
	for (int j = 0; j < A.get(i).size(); i++) {
		if (A.get(i).get(j) != B.get(i).get(j)) {
			return 0;
		}
	}
}
return 1;
```
