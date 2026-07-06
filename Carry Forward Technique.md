
# Primitive: Carry Forward Technique

**Definition**

Carry Forward is a state that preserves information from previous iterations to compute the current state.


**Purpose**

Avoid recomputing information that can be incrementally maintained. 


**Invariant**

After processing index `i`, the carried state correctly summarizes all information required from the previous iterations.


**Operation**

```
state = initialState

for each element {
	
	state = update(state, current)
	
	query(state)
}
```


## Specializations 

- [[Running Sum]]
- Running Maximum 
- Running Minimum 