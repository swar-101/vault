You are given an integer array **A**. You have to find the second largest element/value in the array or report that no such element exists.


[1, 5, 11, 3, 23]
1 23
5 3
11

# [14, 5, 6, 8, 32, 16]
14,  16 >> m : 16 | 2m: 14
32, 5 >>  m: 32  | 2m : 16
   
```java

public int findSecondLargest() {
	int left = 0;
	int right = A.size() - 1;
	int max = A.get(right);
	int maxTwo = A.get(left);
	
	while (left <= right) {
		if (A.get(left) > A.get(right)) {
			max = Math.max(max, A.get(left));
			if (maxTwo < max) {
				maxTwo = Math.max(maxTwo, A.get(right));
			}
		} 
		left++;
		right--;
	}
	if (left == right) {
		Math.max(max, A.get(left));
		if (A.get(left) < max) {
			maxTwo = A.get(left);
		}
	}
}

```


```java

public int findSecondLargest(ArrayList<Integer> A) {
	int max = -1;
	int maxTwo = -1; 

	if (A.size() == 1) return -1; 

	for (int i = 0; i < A.size(); i++) {
		max = Math.max(max, A.get(i));
	}

	for (int i = 0; i < A.size(); i++) {
		if (A.get(i) < max) {
			maxTwo = Math.max(maxTwo, A.get(i)); 
		}
	}

	return maxTwo == -1 ? -1 : maxTwo;
}

```
