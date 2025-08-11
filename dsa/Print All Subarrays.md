
Given an integer array `A` of length `N`, print all possible contiguous subarrays of `A`.  
A subarray is defined as a sequence of elements from the array that are contiguous in memory (no gaps), and their order is preserved.

Each subarray should be printed in the format:

- Enclosed in square brackets `[ ]`
    
- Elements separated by a comma and a space `,`
    
- One subarray per line
    

---

**Example**

```
Input:
A = [1, 2, 3]

Output:
[1]
[1, 2]
[1, 2, 3]
[2]
[2, 3]
[3]
```

---

**Constraints**

- `1 <= N <= 100`
    
- `-10^3 <= A[i] <= 10^3`
    
- Output order must follow:
    
    - Subarrays starting at index `0` first, then `1`, and so on.
        
    - For each starting index, expand towards the end of the array.
        
---



