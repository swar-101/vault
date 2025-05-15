You are given two integer A and B. 
Set the A<sup>th</sup> and B<sup>th</sup> bit in 0, and return output in Decimal Number System.

> Problem Constraint

0 <= A <= 30 
0 <= B <= 30 

## Solution

A = 3
B = 5

5 4 3 2 1 0
 |  |  |  |  |  |
1 0 1 0 0 0  

A << 3
1 0 0 0

A << 5
1 0 0 0 0 0
----1 0 0 0 
1 0 1 0 0 0 


#trap #edgeCase 
# Trap

What if A and B are equal? This will distort our answer. 

A = 4
B = 4

1 << A = 1 << 4 = 1 0 0 0
1 << B = 1 << 4 = 1 0 0 0

----1 0 0 0 
----1 0 0 0
=1 0 0 0 0 

The answer is should've been 1000. But it's 10000 which is not the expected answer.

We handle this edge case checking if A and B are equal. And if they are, we use the Left Shift Operator only once.

```java
public int setBits(int A, int B) {
	if (A == B) 
		return 1 << A;  // This edge case will avoid the distortion
		
	return (1 << A) + (1 << B);
}
```


