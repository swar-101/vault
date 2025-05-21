# Prefix Sum Technique

The **Prefix Sum** technique is a fundamental array-processing trick used in many coding problems to reduce time complexity from `O(n)` per query to `O(1)` per query after `O(n)` preprocessing.

---

## What is Prefix Sum?

It is an array that stores the cumulative sum of elements up to a given index.  
For an array `arr[]`, the prefix sum at index `i` is:

```
prefix[i] = arr[0] + arr[1] + ... + arr[i]
```

Using this, the sum of elements between any two indices `L` and `R` can be calculated in constant time:

```
sum = prefix[R] - prefix[L - 1]
```

(Assuming 0-based indexing and prefix[-1] = 0)

---

## Why Use Prefix Sum?

Instead of recalculating the sum again and again for every query, we **precompute** it once.  
This speeds up range queries, making them lightning fast.

---

## Common Use Cases

- **Range sum queries**: Fast lookup of sum in subarrays.
    
- **Subarray count problems**: Count number of subarrays meeting a condition.
    
- **Kadane’s Algorithm tweaks**: When checking for specific segment sums.
    
- **Matrix Prefix Sum**: For 2D range queries.
    
- **Binary or frequency-based questions**: Even-Odd indexes, bitwise, etc.
    

---

## Variants of Prefix Sum

### 1. Even Prefix Sum

Only sums values at **even indices**.

```java
evenPrefix[i] = evenPrefix[i-1];
if (i % 2 == 0) evenPrefix[i] += arr[i];
```

### 2. Odd Prefix Sum

Only sums values at **odd indices**.

```java
oddPrefix[i] = oddPrefix[i-1];
if (i % 2 != 0) oddPrefix[i] += arr[i];
```

Used in problems where you need to compare even-index and odd-index values separately.

---

### 3. Product Prefix

Instead of summing, it multiplies.

```java
prodPrefix[i] = prodPrefix[i-1] * arr[i];
```

Useful when dealing with multiplicative queries (e.g., in probability or combinatorics problems).  
Edge case: Handle `0` carefully to avoid entire product becoming zero.

---

## #intuition💡 

- Don't repeat work. Compute once, use many times.
    
- Think of **prefix sum** as a running total.
    
- Helps to flatten multiple sum operations into a constant-time lookup.
    

---

## #observations👁️ 

- For sum between `L` and `R`: use `prefix[R] - prefix[L - 1]`.
    
- Edge cases: Handle `L = 0` properly to avoid out-of-bounds.
    
- If queries are known beforehand, this technique is a no-brainer.
    
- Prefix variants are powerful when filters (like even/odd) are involved.
    

---

## Summary

Prefix Sum is a **preprocessing trick** that turns repeated linear work into constant-time lookups. By tweaking how we compute the prefix (sum, product, even, odd, etc.), we adapt it to various problem needs.

Use it when:

- You see repeated sum or product queries.
    
- You want to speed up brute force.
    
- Constraints are tight on time but loose on space.
    

---

## Code Examples: 

### Java 

1. Using primitive arrays

```java
public class PrefixSum {

	public int[] prefixSum(int[] a) {
		int[] prefixSumArray = new int[a.length];		
		prefixSumArray[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			prefixSumArray[i] = prefixSum[i - 1] + a[i];
		}
		return a;
	}
}
```

2. Using `ArrayList` from Java Collections: 

```java
public class PrefixSum {

	public List<Integer> prefixSum(ArrayList<Integer> a) {
		List<Integer> prefixSumArray = new ArrayList<>();
		prefixSumArray.add(a.get(0));

		for (int i = 1; i < a.size(); i++) {
			int sum = prefixSumArray.get(i - 1) + a.get(i);
			prefixSumArray.add(sum);
		}
		
		return prefixSumArray;
	}
}
```

