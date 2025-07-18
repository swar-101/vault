

- [[Wrap-around]]


## The Core Properties 

### 🔢 Modular Arithmetic Reference

**Condition:**
$$
\begin{aligned}
\text{if} \quad a < b \\
\text{then} \quad a \% b = a
\end{aligned}
$$

**Examples:**
$$
a \% 1 = 0
$$

$$
a \% a = 0
$$

---

**Properties of Modular Arithmetic:**

- Addition:
  $$
  (a + b) \% m = \left( (a \% m) + (b \% m) \right) \% m
  $$

- Subtraction (handles negatives):
  $$
  (a - b) \% m = \left( (a \% m) - (b \% m) + m \right) \% m
  $$

- Multiplication:
  $$
  (a \cdot b) \% m = \left( (a \% m) \cdot (b \% m) \right) \% m
  $$

- Exponentiation:
  $$
  (a^b) \% m = \text{modularExponentiation}(a, b, m)
  $$

- Division (modular inverse):
  $$
  \left( \frac{a}{b} \right) \% m = (a \cdot b^{-1}) \% m
  $$

---

> ℹ️ Use `b^{-1}` as the modular inverse of `b mod m`, only if `gcd(b, m) = 1`


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