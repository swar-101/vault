
**Problem Description**
Given a matrix of integers of A of size **N x M** and multiple queries **Q**, for each query, find and return the submatrix sum. 

Inputs to queries are **top left (b, c)** and **bottom right (d, e)** indexes of submatrix whose sum is to be found out. 

--- 

A = \[
\[1, 2, 3 \]
\[4, 5, 6 \]
\[ 7, 8, 9 \] \]

B = \[ 1, 2 \]
C = \[ 1, 2 \]
D = \[ 2, 3 \]
E = \[ 2, 3 \]


| idx   | **1** | **2** | **3** |
| ----- | ----- | ----- | ----- |
| **1** | 1     | 2     | 3     |
| **2** | 4     | 5     | 6     |
| **3** | 7     | 8     | 9     |

| idx   | **1** | **2** |
| ----- | ----- | ----- |
| **2** | 4     | 5     |
| **3** | 7     | 8     |


4 + 5 + 7 + 8 = 20