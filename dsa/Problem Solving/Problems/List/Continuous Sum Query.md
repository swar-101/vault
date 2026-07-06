
# Problem: Continuous Sum Query / Beggars Outside Temple 
## Related

Primitive:
- [[Running Sum]]

Pattern:
- [[Difference Array]]

There are **A** beggars sitting in a row outside a temple.
Each beggar initially has an empty pot.
When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin (according to their faith and ability) to some K beggars sitting next to each other. 

Given the amount P donated by each devotee to the beggars ranging from L to R index, where 
- 1 <= L <= R <= A

Find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.

For the i<sup>th</sup> devotee `B[i][0]=L`, `B[i][2]=P`, given by the 2D Array array B.

---
### Recognition

Multiple range updates followed by one final reconstruction.
## Solution 

A = 5
`B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]`

`[L, R, P]`

L = left
R = Right
P = Amount
A = Number Of Beggars


1  10  
2  10 + 20 + 25 
3  20 + 25
4  25
5  25

### Brute Force :


1. Initialize an array of size A.
2. Loop over B and get the range and amount which was given. 


```java
List<Integer> amountsReceived = new ArrayList<>(Collections.nCopies(A, 0));

for (int i = 0; i < B.size(); i++) {
	int l = B.get(i).get(0) - 1;
	int r = B.get(i).get(1) - 1;
	int p = B.get(i).get(2);

	for (int j = l; int j <= r; j++) {
		if (amountsReceived.get(j) == null) {
			amountsReceived.add(p);
		} else {
			amountsReceived.get(j).set(j + p);
		}
	}
}

return amountsReceived
```


This solution is not optimal. The complexity of this solution is O(n\*q). We can do it in linear time. 


### Optimized Solution: Difference Array + Running Sum

`A = 5`
`B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]`

0. We initialize a new array with size A and all elements as 0.
1. We update P only at the left index positively and the rest of them are still 0. i.e. B[L] = P
2. Mark the index immediately after the right boundary negatively.  
	diff[R + 1] -= P

We mark where each donation starts and where its effect ends. A running sum reconstructs the final amount for every beggar.

+P → donation starts

-P → donation stops

The running sum naturally applies the donation to every beggar in between.

### Code : 

```java
List<Integer> amountsReceived = new ArrayList<>(Collections.nCopies(A, 0));

for (int i = 0; i < B.size(); i++) {
	int l = B.get(i).get(0) - 1;
	int r = B.get(i).get(1) - 1;
	int p = B.get(i).get(2);

	amountsReceived.set(l, amountsReceived.get(l) + p);
	if (r + 1 < A) {
		amountsReceived.set(r + 1, amountsReceived.get(r + 1) - p);
	}
}

int sum = 0;
for (int i = 0; i < amountsReceived.size(); i++) {
	sum += amountsReceived.get(i);
	amountsReceived.set(i, sum);
}

return amountsReceived;
```

### Complexity

Brute Force:
Time: O(Q × N)
Space: O(N)

Optimized:
Time: O(Q + N)
Space: O(N)
