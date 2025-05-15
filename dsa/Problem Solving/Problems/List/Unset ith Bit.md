You are given two integers A and B.
- If B<sup>th</sup> bit in A is set, make it unset
- If B<sup>th</sup> bit in A is unset, leave it as it is.

Return the updated A value.

> Problem Constraint

1 <= A <= 10<sup>9</sup>
0 <= B <= 30 

---
Example 1: 
A = 10
B = 3

*10 in binary is 1010*
1. To set the 3 bit from right, we do a Left Shift Operation between 1 and B.
>`1 << B`
  *This operation will give us, 1 << B = 0100.
  This means our 3<sup>rd</sup> bit is set*

2. We do a NOT Operation on this Left Shift Operation. To make the 3<sup>rd</sup> bit from right as 0 and all the others as 1. 
> `~(1 << B)`
> *This operation will give us, ~(0100) = 1011.*

3. In order to unset A's set 3<sup>rd</sup> bit from right and also keeping intact all the other bits of A, we do an AND operation between A and this NOT operation on the Left Shift Operation between 1 and B.
> `A & ~(1 << B)`
> *This operation will give us, 1010 & 1011 = 1010*
> *We do an AND operation so that we are able to unset the bit only if it's set.
   Because an AND operation does the following: 
  1 & 0 = 0
  1 & 1 = 1*


1 << B = 1 << 3 = 0 1 0 0 
~(1 << B) = 1 0 1 1 

1 0 1 0 
1 0 1 1 
1 0 1 0

Example 2: 
A = 7
B = 2  

1 << B = 1 << 2 = 0 1 0 
~(1 << B) = 1 0 1

1 1 1 
1 0 1
1 0 1






