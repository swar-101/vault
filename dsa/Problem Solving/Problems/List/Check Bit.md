
You're given two integers A and B
- Return 1 if Bth bit in A is set
- Return 0 if Bth bit in A is unset

> Constraints
> 1 <= A <= 10^9
> 0 <= B <= 30

---
## Solution: 

1. We use Left Shift Operator to shift B to its Significant Bit position using 1. 
2. Then we use AND Operator to find if this Bth bit is set.

We use (A & (1 << 2))

Example: 

	A = 10
	B = 2

*We have to check if 10 -> 1010, 2nd Bit is set*

1. Left Shift Operation: 
		1 << B
		1 << 2 
		0001 << 2 = 0010
		
2. AND Operation: 
		A = 10 -> 1010

	A & (1 << B) = 1010 & 0010

   1 0 1 0 
&    0 0 1 0
=    0 0 1 0  -> 1 (in decimal)

This means the bit is set. 


```java
public int isBthSet(int A, int B) {
	return A & (1 << 2) != 0 ? 1 : 0;  
}
```


#trap 

## Why not `A & (1 << 2) == 1 ? 1 : 0`? 

#edgeCase

A = 4
B = 4

1 << B = 1 << 2 -> 100 
A = 4 -> 100

Now, 4 & 4 

>    1   0   0 
 &  1    0   0 
 =   1   0   0 

This means, 4 & 4 = 4, which is not equal to 1. 

