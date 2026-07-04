# 🚆 Swar’s Offline Coding Drill Pack

## Instructions
- Spend max 10–15 mins per problem
- Write code fully (no skipping)
- Test with your own cases
- Only check answer sheet AFTER attempting

---

# 🔥 Problems

## 🧩 Problem 1: GCD of Array

Given an array of integers, find the GCD of all elements.

### Input
```
[12, 18, 24]
```

### Expected Output
```
6
```

### Edge Cases to Test
- [1,1,1]
- [7]
- [0, 10]

---

## 🧩 Problem 2: Count Subarrays with Sum K

Given an array, count number of subarrays with sum = k.

### Input
```
arr = [1, 2, 3]
k = 3
```

### Expected Output
```
2
```

### Edge Cases
- negatives
- zeros
- large values

---

## 🧩 Problem 3: Prime Sieve

Print all primes ≤ n using Sieve of Eratosthenes.

### Input
```
n = 30
```

### Expected Output
```
2 3 5 7 11 13 17 19 23 29
```

---

## 🧩 Problem 4: Modular Exponentiation

Compute (a^b) % m efficiently.

### Input
```
a = 3, b = 57, m = 7
```

### Expected Output
```
6
```

---

## 🧩 Problem 5: BFS Traversal

Given graph:
```
1 — 2 — 3
|    |
4 — 5
```

Start BFS from node 1.

### Expected Output
```
1 2 4 3 5
```

---

## 🧩 Problem 6: 2D Prefix Sum

Given matrix:
```
2 4 1
3 5 7
1 2 6
```

Query sum from (1,1) to (2,2) (0-based)

### Expected Output
```
5 + 7 + 2 + 6 = 20
```

---

# ✅ Answer Sheet (Check ONLY After Solving)

## ✔ Problem 1
Use iterative GCD:
```
gcd(a, b) = gcd(b, a % b)
```
Reduce across array

---

## ✔ Problem 2
Use prefix sum + hashmap:
- store freq of prefix sums
- if (sum - k) exists → add count

---

## ✔ Problem 3
- boolean array
- mark multiples
- start from i*i

---

## ✔ Problem 4
Binary exponentiation:
```
if b even → (a^(b/2))^2
if odd → a * (a^(b-1))
```

---

## ✔ Problem 5
- queue
- visited array
- process neighbors level by level

---

## ✔ Problem 6
Build prefix matrix:
```
P[i][j] = A[i][j]
+ P[i-1][j]
+ P[i][j-1]
- P[i-1][j-1]
```

Query using inclusion-exclusion

---

# 🧠 Reflection

After solving, note:
- Where you got stuck
- Where logic was unclear
- Where implementation broke

That’s your real syllabus.

