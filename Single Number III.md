#medium

Given an array of positive integers **A**, two integers appear only once, and all other integers appear twice.
Find the two integers that appear only once.

> Problem Constraints
> 2 < = |A| <= 10<sup>5</sup>
> 1 <= A[i] <= 10<sup>9</sup>

## Solution

A = [1, 2, 3, 1, 2, 4]


### Step 1:  XOR all numbers to get the two integers that appear only once 

Let's consider a variable, 
int xor = 0; 

We perform XOR on every element in the array. This XOR operation will cancel out all the integers that appear twice, shown as follows: 

```java
int xor = 0;

for (int num : A) {
	xor = xor ^ num;
}
```

1 ^ 2 ^ 3 ^ 1 ^ 2 ^ 4  = 3 ^ 5 -> 011 ^ 101

  011
  101
=110

Therefore, xor = 110
This implies that the two numbers which appears only once, results to this number.
Here, 3 ^ 5 = 110



---
#blocker 
#### Blocker 1: How can we extract 3 and 4?
Here, we cannot directly extract these two numbers by reversing the Bitwise XOR operation. Simply because, the possibilities of getting the same result with numbers other than 3 and 4 is also possible. 

This basically means, 3 ^ 5 = 110, but we can't say the every 110 comes from only a 3 ^ 5 operation.

#intuition💡
#### The Intuition:  Finding how these two integers are different from each other

Although, we cannot reverse the XOR operation directly to get the two integers that appear only once. We can definitely get some useful information about these two integers. 

3 -> 0 1 1
5 -> 1 0 1 
=     1 1 0

So, what's is the difference between 3 and 5? 
 0 1 1 vs. 1 0 1

1<sup>st</sup> bit from the right is set in both the numbers. 
2<sup>nd</sup> bit from the right is set in 3 and unset in 5. A-ha! This is exactly what separates 3 and 5. 


---
#blocker
#### Blocker 2: How do we check at which position in these two integers the bit is different? 

In the value of the`xor` variable, if the bit at the x<sup>th</sup> position is 1, this means that bit at the x<sup>th</sup> position in these two integers are different. 


#intuition💡 
#### The Intuition: Using Left Shift Operation And Bitwise AND Operation

In order to verify this, we use the Bitwise AND Operation on the `xor` variable. 

And we iterate by shifting a set bit to the left by using the Left Shift Operator until we find the position where the bit is different. 

The loop will something like: 

```
int diffBit = 1; 
while (xor & diffBit == 0) {
	diff = diff << 1;
}
```

*Let's initialize, 
`diffBit = 1`*

`xor & diffBit`

xor      =  1 1 0 
diffBit  =  0 0 1
       =  0 0 0 

*1<sup>st</sup> iteration*

diffBit << 1 = 1 << 1
	       = 0 1 0 


`xor & diffBit`

xor     =  1 1 0 
diffBit =  0 1 0 
      =  0 1 0 

We found the position at which the bit is different. 


### Step 3: 






