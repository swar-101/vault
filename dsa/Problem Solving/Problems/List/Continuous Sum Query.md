There are **A** beggars sitting in a row outside a temple.
Each beggar initially has an empty pot.
When the devotees come to the temple, they donate some amount of coins to these beggars. Each devotee gives a fixed amount of coin (according to their faith and ability) to some K beggars sitting next to each other. 

Given the amount P donated by each devotee to the beggars ranging from L to R index, where 
- 1 <= L <= R <= A

Find out the final amount of money in each beggar's pot at the end of the day, provided they don't fill their pots by any other means.

For the i<sup>th</sup> devotee `B[i][0]=L`, `B[i][2]=P`, given by the 2D Array array B.

---
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
List<Integer> amountsRecieved = new ArrayList<>(Collections.nCopies(A, 0));

for (int i = 0; i < B.size(); i++) {
	int l = B.get(i).get(0) - 1;
	int r = B.get(i).get(1) - 1;
	int p = B.get(i).get(2);

	for (int j = l; int j <= r; j++) {
		if (amountsRecieved.get(j) == null) {
			amountsRecieved.add(p);
		} else {
			amountsRecieved.get(j).set(j + p);
		}
	}
}

return amountsRecieved
```


This solution is not optimal. The complexity of this solution is O(n\*q). We can do it in linear time. 


### Optimized Solution: Using difference array and prefix sum 

`A = 5`
`B = [[1, 2, 10], [2, 3, 20], [2, 5, 25]]`

0. We initialize a new array with size A and all elements as 0.
1. We update P only at the left index positively and the rest of them are still 0. i.e. B[L] = P
2. The index after the right limit we update it negatively. i.e. B[R] = -P


This will enable us to set checkpoints that will enable our prefix sum to update the indices only until the required range. 

Let's say there are two queries: 
`[[L, R, P], [R+1, C, M]]`

The prefix sum of the range from L to R would P. 
The prefix sum of the range from R+1 to C would be -P + P + M = M.

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
	amountsRecieved.set(i, sum);
}

return amountsReceived;
```