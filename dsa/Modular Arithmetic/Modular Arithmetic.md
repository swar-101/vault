

- [[Wrap-around]]


## The Core Properties 

Burn these into your memory: 

- (a + b) % m = ((a % m) + (b % m)) % m 
- (a - b) % m = ((a % m) - (b % m) + m) % m  <- handle negatives.
- (a * b) % m = ((a % m) * (b % m)) % m 
- (a ^ b) % m = modularExponentiation(a, b, m) 
- (a / b) % m = (a * b<sup>-1</sup>) % m <- modular inverse.


## Exponentiation By Squaring 

- Practice writing modular exponentiation from scratch.
- Solve: 

> Know how and why (a ^ b) % m is done in O(log b) using squaring.



## Understand Modular Inverse (The Boss Level)

When you see:

```java
a / b % m
```


You're not allowed to divide directly. You must use: 

```java
a * inverse(b) % m
```

But the inverse only exists if: 

```

```