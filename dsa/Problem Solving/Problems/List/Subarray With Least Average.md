#easy 

Given an array **A** of size **N**, find the subarray of size **B** with the least average.  
  .
> **Problem Constraints**  

1 <= B <= N <= 10<sup>5</sup>
-10<sup>5</sup> <= A[i] <= 10<sup>5</sup>

> **Input**

A = [3, 7, 90, 20, 10, 50, 40]
B = 3

> **Output**



---
## Solution

A = [3, 7, 90, 20, 10, 50, 40]

#intuition💡 

We use the [[Sliding Window Technique]] to loop over all the elements once to find the least average possible.


Steps: 
1. We initialize a variable min with the [[Maximum Integer Value]]. 

```java
int windowSum = 0;
// 1st window
for (int i = 0; i < B; i++) {
	windowSum += A.get(i) 
}
double minAverage = (double) windowSum / B;
int minIndex = 0;


for (int end = B; end < A.size(); end++) {
	windowSum += A.get(end) - A.get(end - B);
	(double) currentAverage = (double) windowSum / B;
	if (currentAverage > minAverage) {
		minAverage = currentAverage;
		minIndex = end - B + 1;
	}
}

return minIndex;
```

A = [3, 7, 90, 20, 10, 50, 40]

*1<sup>st</sup> window*

| i   | A[i] | windowSum |
| --- | ---- | --------- |
| 0   | 3    | 3         |
| 1   | 7    | 3+7       |
| 2   | 90   | 3+7+90    |
windowSum = 100
minAverage = windowSum / B
minAverage = 100/3 = 33.333

*Sliding to the next elements*

A = [3, 7, 90, 20, 10, 50, 40]

| end | widowSum           | currentAverage   | minAverage |
| --- | ------------------ | ---------------- | ---------- |
| -   | 100                | -                | 33.333     |
| 3   | 100 + 20 - 3 = 117 | 117 / 3 = 39     | 33.333     |
| 4   | 117 + 10 - 7 = 120 | 120 / 3 = 60     | 33.333     |
| 5   | 120 + 50 - 90 = 80 | 80 / 3 = 26.666  | 26.666     |
| 6   | 80 + 40 - 20 = 100 | 100 / 3 = 33.333 | 26.666     |
