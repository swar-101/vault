#medium 

You are given a 2D integer matrix A, make all the elements in a row or column zero if the `A[i][j] = 0`.  Specifically make the entire i<sup>th</sup> row and j<sup>th</sup> column zero.

> Problem Constraints

1 <= A.size <= 10<sup>3</sup>
1 <= A[i].size() <= 10<sup>3</sup>
0 <= `A[i][j]` <= 10<sup>3</sup>


> Input

```
[1, 2, 3, 4]
[5, 6, 7, 0]
[9, 2, 0, 4]
```

> Output

```
[1, 2, 0, 0]
[0, 0, 0, 0]
[0, 0, 0, 0]
```