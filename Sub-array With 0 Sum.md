
**Problem Description**

Given an array of integers **A**, find and return whether the given array contains a **non-empty** subarray with a sum equal to 0. 
If the given array contains a sub-array with sum zero return 1, else return 0.

--- 

A = \[1, 2, 3, 4, 5\]


1. We create a prefix sum array.
2. While creating a prefix sum array, if any prefix sum at `i` is 0, we return 1. 
3. We create a HashSet. This HashSet will store unique prefix sums. 
4. We iterate over the prefix sum array, if the any prefix sum at `i` is present in the HashSet we return 1. 
5. Outside the loop, we return 0. 

