```

nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output = 6

```


Steps: 

In order to solve this problem, we don't need to store the subarrays, but get a sum of each subarray.

We can use [[Kadane's Algorithm]] to get the combination of each subarray by moving the pointers to find out the Maximum Sum.

We move to the next element and decide whether to extend the current subarray (`currentSum + nums[i]`) or start a new one (`nums[i]`), depending on which gives a larger sum.

If the input array is, 

| i         | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   | 8   |
| --------- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| nums\[i\] | -2  | 1   | -3  | 4   | -1  | 2   | 1   | -5  | 4   |


We keep track of its local sum `currentSum` and the global sum `maxSum`. The `maxSum` will be returned after comparing all the possible combinations and tracking all the sums we've calculated so far.

We'll initialize, 
`currentSum = nums[0]` and
`maxSum = nums[0]`


We’ll loop over the rest of the array to determine if we can find a subarray with a larger sum.
If we find a sum larger than the current sum we update `currentSum`. 
We compare  `currentSum` with `maxSum` and update `maxSum`.
We finally return `maxSum` when all the elements are visited. 


### Dry Run

| i   | nums\[i\] | currentSum + nums[i] or nums[i]    | currentSum | currentSum or maxSum | maxSum |
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


### Why compare `nums[i]` and `currentSum + nums[i]` ?
### `max(currentSum + nums[i], nums[i])`

The calculation `currentSum + num[i]` represent the current state of the sum of elements where the sum could be the maximum. 

#insight💡 
Like other [[Sliding Window Technique]] problems, we don't have to remove left as this would be unnecessary because we're comparing `currentSum` on the go. 

Every time there is a new element `nums[i]` which happens to be greater than the `currentSum`, we ignore the previously calculated `currentSum + nums[i]` because, this new element `nums[i]` definitely beats this previously calculated `currentSum + nums[i]`.

### Why compare `currentSum` and `maxSum`?
### `max(currentSum, maxSum)`


As there is a possibility that we find `nums[i]` greater than `currentSum + nums[i]`, this will reset our previously calculated `currentSum`.

We will not find the maximum sum if `currentSum` gets reset every time there is a `num[i]` winner from the `max(currentSum + nums[i], nums[i])` comparison.

There might be many such winners across the array, that's why we need this `max(currentSum, maxSum)` comparison.


#insight💡 

> We use a **greedy, dynamic windowing technique** similar in spirit to sliding window, but instead of maintaining a fixed size or shrinking from the left, we reset the sum when a single element becomes larger than the current window.


#intuition💡 

> 🧠 **Kadane's Algorithm**: Turn pain (-ve numbers) into gain (max subarray), one greedy step at a time.


### Code

Java: 

```java

int currentSum = nums[0];
int maxSum = nums[0];

for (int i = 1; i < nums.length; i++) {
	currentSum = Math.max(currentSum + nums[i], nums[i]);
	maxSum = Math.max(currentSum, maxSum);
}
return maxSum;
```

