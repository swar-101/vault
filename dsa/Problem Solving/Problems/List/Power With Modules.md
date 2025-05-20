You are given A, B and C.

Calculate the value of (A ^ B) % C.

> **Problem Constraints**

1 <= A <= 10<sup>9</sup>
0 <= B <= 10<sup>5</sup>
1 <= C <= 10<sup>9</sup>

> **Input**

A = 2
B = 3
C = 3

> **Output**

2

---

### Solution 

```java
long result = 1; 
long base = A % C;

while (B > 0) {
	if ((B & 1) == 1) {
		result = (result * base) % C;
	}
	base = (base * base) % C;
	B >>= 1;
}

return (int)((result + C) % C);
```
