# Pattern: Prefix, Suffix Precomputation

**Definition**

Prefix/Suffix Precomputation stores information computed from the left and right so each index can be answered in $O(1)$. 


**Purpose**

Avoid recomputing information from both directions for every index. 


**Recognition**

Each index depends on information from both the left and the right, and the input is static.


**Invariant**

For every index `i`: 
- `prefix[i]` summarizes information from the start up to `i`.
- `suffix[i]` summarizes information from `i` to the end. 


**Operation**

```
prefix[0] = base 

for i from 1 → n:
	prefix[i] = combine(prefix[i - 1], nums[i])

suffix[n - 1] = base

for i from n - 2 → 0: 
	suffix[i] = combine(suffix[i + 1], nums[i])
```


## Problems 

1. [[Product Array Puzzle]]
2. [[Rain Water Trapped]]