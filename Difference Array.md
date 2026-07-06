# Pattern: Difference Array

**Definition**
Difference Array stores changes (events) instead of the final values.


**Purpose**
Efficiently apply multiple range updates without updating every element.


**Invariant**
- +value → effect starts here 
- -value → effect stops after this point

The final values are reconstructed using a running sum.


**Construction**

```
left = start
right = end

diff[left] += value 

if (right + 1 < n): 
	diff[right + 1] -= value 
```


**LeetCode** 


**Internal** 
1. [[Continuous Sum Query]]