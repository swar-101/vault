
#medium🟠 

Imagine there is a histogram where the bars' heights are given by the array A.
Each bar is of uniform width, which is 1 unit.
When it rains, water will accumulate in the valley between the bars.

Your task is to calculate the total amount of water that can be trapped in these valleys.

> **Problem Constraints**

1 <= |A| <= 10<sup>5</sup>
0 <= A[i] <= 10<sup>5</sup>

>**Visualization**

[[Rain Water Trap Visualization.canvas|Rain Water Trap Visualization]]


---

### Solution



Example: 

A = [5, 4, 1, 4, 3, 2, 7]


A = [1, 2, 1, 4]



```java
```



If we're at an i<sup>th</sup> position, 
The amount of rain water that can be trapped can be given as follows.


`min(leftMax[i], rightMax[i]) - height[i]`


```java
int water = 0; 
int left = 0, right = A.size() - 1;
int leftMax = A.get(0), rightMax = A.get(A.size() - 1);

if (A.size() <= 2) return 0; 

while (left < right) {
	int currentLeftHeight = A.get(left);
	int currentRightHeight = A.get(right);
	if (currentLeftHeight < currentRightHeight) {
		if (currentLeftHeight >= leftMax) {
			leftMax = currentLeftHeight;
		} else {
			water += leftMax - currentLeftHeight;
		}
		left++;
	} else {
		if (currentRightHeight >= rightMax) {
			rightMax = currentRightHeight;
		} else {
			water += rightMax - currentRightHeight;
		}
		right--;
	}
}
return water;

```