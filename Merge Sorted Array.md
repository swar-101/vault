
nums1 = 1, 2, 3, 0, 0, 0 
m = 3
2, 5, 6

nums2 = 2, 5, 6
n = 3

Output
1, 2, 2, 3, 5, 6





| i   | nums1[i] | nums2[i] | nums1[i] | temp |
| --- | -------- | -------- | -------- | ---- |
| 5   | 0        |          | 1        | 2    |
| 4   | 0        |          | 2        | 2, 5 |
| 3   | 0        |          | 2        |      |
| 2   | 3        | 6        |          |      |
| 1   | 2        | 5        |          |      |
| 0   | 1        | 2        |          |      |

```java

int n = nums2.length;
int m = nums1.length - n;
int p1 = m - 1; 
int p2 = n - 1; 
int p = m + n - 1;

while (p1 >= 0 && p2 >= 0) {
	if (nums1[p1] > nums2[p2]) {
		nums1[p] = nums1[p1];
		p1--;
	} else {
		nums1[p] = nums2[p2];
		p2--;
	}
	p--;	
}

while (p2 >= 0) {
	nums1[p] = nums2[p2];
	p2--;
	p--;
}
```
