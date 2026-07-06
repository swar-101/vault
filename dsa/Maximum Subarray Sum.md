
# Problem: Maximum Subarray 

Given an integer array `nums`, find the subarray with the largest sum, and return _its sum_.

**Example 1:**

**Input:** nums = [-2,1,-3,4,-1,2,1,-5,4]
**Output:** 6
**Explanation:** The subarray [4,-1,2,1] has the largest sum 6.

**Example 2:**

**Input:** nums = [1]
**Output:** 1
**Explanation:** The subarray [1] has the largest sum 1.

**Example 3:**

**Input:** nums = \[ 5, 4, -1, 7, 8 \]
**Output:** 23
**Explanation:** The subarray [5,4,-1,7,8] has the largest sum 23.

**Constraints:**

- `1 <= nums.length <= 105`
- `-104 <= nums[i] <= 104`


## Solution 


```

nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output = 6

```


Steps: 

In order to solve this problem, we don't need to store the subarrays, but get a sum of each subarray.

We can use [[Kadane's Algorithm]] to get the combination of each subarray by moving the pointers to find out the Maximum Sum.

We move to the next element and decide whether to extend the current subarray (`bestEndingHere + nums[i]`) or start a new one (`nums[i]`), depending on which gives a larger sum.

If the input array is, 

| i         | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   |
| --------- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| nums\[i\] | -2  | 1   | -3  | 4   | -1  | 2   | 1   | -5  | 4   |


We keep track of the best subarray sum ending at the current index (`bestEndingHere`) and the maximum subarray sum seen so far (`globalMax`).

We'll initialize, 
`bestEndingHere = nums[0]` and
`globalMax = nums[0]`


We’ll loop over the rest of the array to determine if we can find a subarray with a larger sum.

At every index, there are only two valid choices:

1. Extend the previous subarray.
2. Start a new subarray from the current element.

We choose whichever gives the larger sum.

### Dry Run

| i   | nums\[i\] | bestEndingHere + nums[i] or nums[i]    | bestEndingHere | bestEndingHere or globalMax | globalMax |
| --- | --------- | ---------------------------------- | ---------- | -------------------- | ------ |
| 0   | -2        | -                                  | -2         | -                    | -2     |
| 1   | 1         | -2+1 or 1 <br>= -1 or 1            | 1          | 1 or -2              | 1      |
| 2   | -3        | 1+(-3) or -3<br>= -2 or -3<br>= -2 | -2         | -2 or 1              | 1      |
| 3   | 4         | -2+4 or 4<br>= 2 or 4<br>= 4       | 4          | 4 or 1               | 4      |
| 4   | -1        | 4 + (-1) or -1<br>= 3 or -1<br>= 3 | 3          | 4 or 3               | 4      |
| 5   | 2         | 3 + 2 or 2<br>= 5 or 2<br>= 5      | 5          | 4 or 5               | 5      |
| 6   | 1         | 5 + 1 or 5<br>= 6 or 5<br>= 6      | 6          | 5 or 6               | 6      |
| 7   | -5        | 6 + (-5) or -5<br>= 1 or -5<br>= 1 | 1          | 6 or 1               | 6      |
| 8   | 4         | 1 + 4 or 4<br>= 5 or 4             | 5          | 6 or 5               | 6      |


### Why compare `nums[i]` and `bestEndingHere + nums[i]` ?
### `max(bestEndingHere + nums[i], nums[i])`

`bestEndingHere + nums[i]` represents extending the best subarray that ended at the previous index.

`nums[i]` represents starting a brand-new subarray at the current index.


#insight💡

> The previous state must be extendable.

> Since the subarray must remain contiguous, we cannot skip elements between the previous subarray and the current element.

### Why initialize with nums[0]?

`bestEndingHere` is a DP state.

The only subarray ending at index 0 is:

[nums[0]]

Therefore,

bestEndingHere = nums[0]
globalMax = nums[0]

This is a base case, not a sentinel initialization.


### Why compare `bestEndingHere` and `globalMax`?
### `max(bestEndingHere, globalMax)`


As there is a possibility that we find `nums[i]` greater than `bestEndingHere + nums[i]`, this will reset our previously calculated `bestEndingHere`. ^c63c15

We will not find the maximum sum if `bestEndingHere` gets reset every time there is a `num[i]` winner from the `max(bestEndingHere + nums[i], nums[i])` comparison.

There might be many such winners across the array, that's why we need this `max(bestEndingHere, globalMax)` comparison.


#insight💡 

> We use a **greedy, dynamic windowing technique** similar in spirit to sliding window, but instead of maintaining a fixed size or shrinking from the left, we reset the sum when a single element becomes larger than the current window.


#intuition💡 

> 🧠 **Kadane's Algorithm**: Turn pain (-ve numbers) into gain (max subarray), one greedy step at a time.


### Code

Java: 

```java

int bestEndingHere = nums[0];
int globalMax = nums[0];

for (int i = 1; i < nums.length; i++) {
	bestEndingHere = Math.max(bestEndingHere + nums[i], nums[i]);
	globalMax = Math.max(bestEndingHere, globalMax);
}
return globalMax;
```

### Invariant

`bestEndingHere` is the maximum subarray sum ending at the current index.

`globalMax` is the maximum subarray sum seen so far.