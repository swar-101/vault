
**Problem Description**

You are given an array of **N** integers, **A<sub>1</sub>, A<sub>2</sub> ,A<sub>3</sub>,...,A<sub>N</sub>** and an integer **B**. Return the count of distinct numbers in all windows of size **B**.


Formally, return an array of size **N-B+1** where where the **i<sup>th</sup>** element in this array contains number of distinct elements in sequence **A<sub>i</sub>, A<sub>i+1</sub>,...,A<sub>i+B-1</sub>.**

**Problem Constraints**

1 <= **N** <= 10<sup>6</sup>
1 <= **A\[i\]** <= 10<sup>9</sup>


**Input Format**
First argument is an integer array A.
Second argument is an integer B.

**Output Format**
Return an integer array.


**Example Input**

Input 1:
A = \[1, 2, 1, 3, 4, 3\]
B = 3

Output 1: 
\[2, 3, 3, 2\]

Input 2: 
A = \[1, 1, 2, 2\]
B = 1

Output 2: 
\[1, 1, 1, 1\]


---


