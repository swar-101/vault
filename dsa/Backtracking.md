**Definition**

It's like trying all possible choices and **undoing a choice if it leads to a dead end.**

> *Do something* -> *Explore further* -> *If failed, undo* -> *Try next thing.*


Basically: 
- Recursive brute force
- Plus undoing move (backtrack)
- Prune impossible paths early 


## Core Pattern 

```java
void backtrack(State state) {
	if (isSolution(state)) {
		process(state);
		return;
	}

	for (Choice c : choices(state)) {
		if (isValid(c, state)) {
			makeChoice(c, state);
			backtrack(state);
			undoChoice(c, state);
		}
	}
}
```


## Classic Use-cases

| Problem Type        | Example                              |
| ------------------- | ------------------------------------ |
| Permutations        | All permutations of a string/array   |
| Combinations        | k-combinations, subset sums          |
| Grid Fill / Maze    | Rat in a Maze, N-Queens              |
| Decision Trees      | Word Break, Expression Add Operators |
| Constraint Problems | Sudoku Solver, N-Queens              |

## Common Pitfalls

| Pitfall                   | Fix                                      |
| ------------------------- | ---------------------------------------- |
| Missing base case         | Always define when to stop recursion     |
| Not undoing properly      | Reverse your changes (e.g., pop, remove) |
| Duplicate results         | Use sets or control start index          |
| Not pruning invalid paths | Add `isValid` checks early               |

## Ultimate Rule

> **Backtracking = Recursive DFS + State Reversion**


