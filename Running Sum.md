# Primitive: Running Sum 

**Definition**

Running sum is a state that accumulates information while traversing a sequence.


**Purpose**

Avoid recomputing previously accumulated information.

**Invariant**

After process index `i`, the running sum represents the accumulation of all values from the start up to `i`.

**Operations**

```
// 1. Initialize
sum = 0

for (i = 0; i < n; i++) {
	// 2. update 
	sum += A[i];
	
	// 3. query 
	if (sum == x) {
		// do something
	}
}
```

