# Algorithm: Kadane's Algorithm 

**Purpose**
Find the maximum-sum contiguous subarray in $O(N)$. 

**Invariant**
Maintain the best subarray sum ending at the current index `bestEndingHere`.
At each element:
- Extend the previous subarray 
- Or start a new subarray 

**State:**

```
bestEndingHere = max(bestEndingHere + nums[i], nums[i])
globalMax = max(globalMax, bestEndingHere)
```


LeetCode 
[Maximum Subarray](https://leetcode.com/problems/maximum-subarray/description/)

Internal 
[[Maximum Subarray Sum]]