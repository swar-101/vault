
# Pattern: Carry Propagation

**Definition**

Carry Propagation propagates an overflow or carry from one position to the next more significant position.


**Purpose**

Ensure arithmetic operations remain correct when a digit cannot absorb the current carry.


**Recognition**

- Arithmetic performed digit by digit.
- Digits are processed from least significant to most significant. 
- An overflow may affect more significant digits.


**Invariant**

All digits to the right of the current position have already been finalized.


**Operation**

```
carry = initialValue 

for i from LSB → MSB: 

	update current digit
	
	if carry absorbed: 
		break 
	else: 
		propagate

```



**Problems**

1. [[Add One To Number]]