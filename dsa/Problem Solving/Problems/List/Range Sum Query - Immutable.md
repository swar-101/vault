# Range Sum Query - Immutable

- **Difficulty:** #easy  
- **Tags:** Array, Design, Prefix Sum

>Problem Description

Given an integer array `nums`, handle multiple queries of the following type:

Calculate the **sum** of the elements of `nums` between indices `left` and `right` **inclusive** where `left <= right`.

Implement the `NumArray` class:

- `NumArray(int[] nums)` Initializes the object with the integer array nums.
- `int sumRange(int left, int right)` Returns the **sum** of the elements of nums between indices `left` and `right` **inclusive** (i.e. `nums[left] + nums[left + 1] + ... + nums[right]`).

 
**Example 1:**

**Input**
    ["NumArray", "sumRange", "sumRange", "sumRange"]
    [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
    **Output**
    [null, 1, -1, -3]

**Explanation**
    NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
    numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
    numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
    numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

 
**Constraints:**

- 1 <= nums.length <= 10<sup>4</sup>
- -10<sup>5</sup> <= nums[i] <= 10<sup>5</sup>
- 0 <= left <= right < nums.length
- At most 10<sup>4</sup> calls will be made to sumRange.

---

## Solution

## Code Definition 

```java

class NumArray {
    public NumArray(int[] nums) {
    }

    public int sumRange(int left, int right) {
    }
}

/**

 * Your NumArray object will be instantiated and called as such:

 * NumArray obj = new NumArray(nums);

 * int param_1 = obj.sumRange(left,right);

 */
```


Steps: 

1. Initialize an array called `prefixSums`.
2. Instantiate a Prefix Sum Array using the constructor
	1. If the input array `nums[]` is null or its size is 0, return an empty array.
	2. Else, create an array `prefixSums` which instantiates the input array `nums[]` as `prefixSums[]`.
3. Use this `prefixSums` array as an index for the range sum queries.
	1. If the `left` is 0, this means the `right` index of `prefixSums` already has the Range Sum. 
	2. Else, return the difference between the `prefixSums` of index `right` and the `prefixSums` of index previous to the `left`, since this difference determines the sum in the range `left` and `right`.


## LeetCode Submission: 

Java: 

```java
class NumArray {

    private int[] prefixSums;
    
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            prefixSums = new int[0];
            return;
        }
        int sum = 0;
        prefixSums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixSums[i] = sum;
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0)
            return prefixSums[right];
        return prefixSums[right] - prefixSums[left - 1];
    }
}
```