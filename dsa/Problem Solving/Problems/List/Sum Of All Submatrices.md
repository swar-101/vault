
Given a 2D Matrix A of dimensions N\*N, we need to return the sum of all possible submatrices.

> **Problem Constraints**

`1 <= N <= 30`
`0 <= A[i][j] <= 10`

> **Input**

`A = [[1, 1], [1, 1]]`


---
### Solution 

We use [[Contribution Technique]].

```java
int n = A.size();
int sum = 0; 
for (int i = 0; i < n; i++) {
	for (int j = 0; j < n; j++) {
		int contribution = (i + 1) 
			* (j + 1) * (n - i) * (n - j) 
			* A.get(i).get(j);
			
		sum += contribution;
	} 
}
return sum;
```