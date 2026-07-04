1. Running Extremes
   - maxSoFar / minSoFar
   - evolving candidates

2. Contribution Technique
   - fix one boundary
   - count participation frequency

3. Carry Forward
   - preserve historical state
   - avoid rescanning

4. Directional Traversal
   - traverse with dependency flow

5. Toggle Parity
   - odd/even flips interpretation

6. Greedy Fixing
   - fix immediately if unavoidable

7. State Compression
   - minimal state preserves truth

8. Invariant Maintenance
   - state relationships must remain valid

9. Constraint Reduction
   - simplify to necessary conditions

10. Incremental Update
   - reuse previous computation

11. Boundary Shifting
   - move partition/window incrementally

12. Fixed Sliding Window
   - move fixed-size window while updating state

13. Matrix Simulation / Boundary Traversal
   - boundaries define valid traversal region

14. Enumeration Geometry
   - contiguous intervals formed via start/end choices

15. Monotonic Window Behavior
   - positive-only expansion/shrinking stays predictable

16. Window Repair Strategy
   - shrink minimally to restore invariant

17. Choice Multiplication
   - independent choices multiply combinations

18. Interval Participation Counting
   - count how often each index contributes

19. Two Pointer Synchronization
   - explorer pointer + repair pointer coordination

20. Prefix History Caching
   - cumulative state enables fast range reasoning

21. Contiguous State Evolution
   - subarrays represent continuous state segments

22. Overlap Preservation
   - retain reusable valid state instead of resetting

23. Valid Region Maintenance
   - maintain only states satisfying constraints

24. Constraint Signature Recognition
   - constraints hint toward viable optimization family
   
   
25. Current Is Not History Yet
	- query before updating to avoid false positives
	
26. Pivot / Center Expansion Pattern 
	- Instead of choosing all combinations directly, 
		fix one element as the CENTER, 
		then compute compatible choices around it. 
		
				
27. Tree Aggregation / Bottom-up Aggregation 
	- Height, count nodes, sum nodes
	- Children computes, parent combines 
	
28. Top-down Context propagation 


29. Parent-child Relationship Detection 

30. Prefix sum repeats the range sum is 0

31. Frequency Consumption 
	- store available occurrences 
	- whenever a match is used: 
		consume one unit of availability 
	- intersection frequency: 
		min(freqA, freqB) 
		
32. Carry Forward + Directional Traversal 


33. Divide & Reduce

- reduce problem size aggressively
- N → N/2
- recursion depth becomes logarithmic

	Examples:
	- Fast Power
	- Binary Search
	- Kth Symbol
		
34. Streaming Modulo Construction / 
	Horner's Method / 
	Large Number Modulo Pattern / 
	Rolling Modulo Computation / 
	Polynomial Evaluation using Horner's Rule 
	
	- remainder = (remainder * base + digit) % MOD
	- where base = 10 for decimal, 2 for binary etc. 
	
35. Test of divisibility using modulo 
	- 3, 4, 8

36. Counting Sort 
	- using frequencies of the element to sort elements
		in descending or ascending order 
		

37. Expand around the centre


38. Vertical Scanning 


39. Sorting + First Occurrence Pattern 
40. Consecutive set bits trick 

41. Event Counting Compression
	
	Instead of computing the final value,
	count how many state-changing events occur.
	
	Examples:
	K-th Symbol Hard
	
	Event:
	Entering Right Half
	
	State Change:
	Toggle
	
	Answer:
	Parity(Event Count)


41. ASCII Case Conversion*
Uppercase and lowercase letters are separated by a fixed offset of 32.  
Use `('a' - 'A')` instead of hardcoding 32.

```java
(char)(c + ('a' - 'A')) // to lower
(char)(c - ('a' - 'A')) // to upper
```


42. Character Range Detection
Use character literals instead of ASCII values for readability.

```java
c >= 'A' && c <= 'Z'
c >= 'a' && c <= 'z'
```
    

43. **4. Count Sort**  
Store frequencies, then rebuild the array in sorted order.

```
Pattern:Frequency Array
```

**Complexity**

```
TC: O(N + K)SC: O(K)
```

Where:

- N = number of elements
- K = value range


44. Reverse Words in a String**  
Extract words, reverse their order, and join with a single space.

```
Pattern:Tokenization + Reverse Traversal
```

**Invariant**

```
Store only valid words.Ignore empty words.
```

**Guard**

```
if (sb.length() > 0) {    array.add(sb.toString());}
```

Use:

- when a delimiter is encountered
- after the loop ends

**Why?**

```
"" is still a valid ArrayList element.Extra elements    ↓Extra separators    ↓Wrong output
```


45. Negative History → Reset 

State:  
Ending Here  
Best So Far  
  
Cue:  
Extend ↔ Restart


45. **Boundaries Determine Capacity** Directional Precomputation
leftMax[]  
rightMax[]  
  
Contribution:  
min(L,R)-H

46. Level 1:  
	Precompute Missing Information  
	(leftMax[], rightMax[])  
	  
	Level 2:  
	Optimize Space  
	(Two Pointers)




# Bit Manipulation 

1. 