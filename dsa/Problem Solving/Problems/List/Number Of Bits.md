Write a function that takes an integer and returns the number of 1 bits present in its binary representation.

> Problem Constraints

 1 <= A <= 10^9

> Input

11 

> Output

3 



## Solution: 

1st iteration: 

n = n & (n - 1)
   = 11 & (11 - 1)
   = 11 & 10

11 & 10 

  1 0 1 1
  1 0 1 0 
=1 0 1 0 

2nd iteration: 

n = n & (n - 1)
   = 10 & (10 - 1)
   = 10 & 9

10 & 9

 1 0 1 0 
 1 0 0 1
=1 0 0 0 

3rd iteration: 

n = n & (n - 1)
   = 8 & (8 - 1)
   = 8 & 7
   
8 & 7 

 1 0 0 0 
 0 1 1 1
=0 0 0 0  


 

n = n & (n - 1)
  =  10 