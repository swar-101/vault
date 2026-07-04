# 🚆 Train Coding Drill Pack v2

## 🎯 Goal
Build execution + recall + self-validation (offline mode)

---

## ⏱️ How to Use
- Spend 10–15 min per problem
- Think → Code → Break
- Do NOT check answers early

---

# 🔹 LEVEL 1 (Core Execution)

## 🧩 P1: GCD of Array
Find GCD of all elements.

Input:
[12, 18, 24]

Output:
6

Test:
[1,1,1]
[7]
[0,10]

---

## 🧩 P2: Subarrays with Sum = K
Count subarrays with sum = k.

Input:
arr = [1,2,3], k = 3

Output:
2

Test:
[0,0,0], k=0
[-1,1,0], k=0

---

## 🧩 P3: Prime Count (Sieve)
Count primes ≤ n

Input:
n = 30

Output:
10

---

## 🧩 P4: Modular Exponentiation
Compute (a^b) % m

Input:
a=3, b=57, m=7

Output:
6

---

## 🧩 P5: 1D Prefix Sum
Range sum query

arr = [2,4,1,3,5]
query: l=2, r=4

Output:
9

---

# 🔹 LEVEL 2 (Decision + Traps)

## 🧩 P6: Subarrays Divisible by K

Input:
[4,5,0,-2,-3,1], k=5

Output:
7

---

## 🧩 P7: GCD Subarrays
Count subarrays with gcd = 1

Input:
[2,4,6,3]

Output:
4

---

## 🧩 P8: Longest Subarray with Sum = K

Input:
[1,-1,5,-2,3], k=3

Output:
4

---

## 🧩 P9: 2D Prefix Sum

Matrix:
2 4 1
3 5 7
1 2 6

Query: (1,1) to (2,2)

Output:
20

---

## 🧩 P10: BFS with State

Grid:
0 0 1
0 1 0
0 0 0

Reach end → true

---

# ✅ ANSWER CHECK (ONLY AFTER ATTEMPT)

## ✔ P1
Euclid GCD, reduce across array

## ✔ P2
Prefix sum + hashmap
count += freq[sum - k]

## ✔ P3
Sieve, mark from i*i

## ✔ P4
Binary exponentiation (log b)

## ✔ P5
prefix[r] - prefix[l-1]

## ✔ P6
prefix % k, same remainder
handle negative mod

## ✔ P7
Maintain gcd map per index
merge ranges

## ✔ P8
Prefix + hashmap, store first index

## ✔ P9
Inclusion-exclusion formula

## ✔ P10
BFS with state (i, j, used_block)

---

# 🧠 Reflection Section

After solving, note:
- Where did I hesitate?
- Where did bugs happen?
- Which concept felt weak?

This = your real syllabus
