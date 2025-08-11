You are given an image represented by `m x n` grid of integers `image`, where `image[i][j]` represents the pixel value of the image. You are also given three `sr`, `sc` and `color`. Your task is to perform a **flood fill** on the image starting from the pixel `image[sr][sc]`.


To perform flood fill: 

1. Begin with the starting pixel and change its color to `color`.
2. Perform the same process for each pixel that is **directly adjacent** (pixels that share a side with the original pixel, either horizontally or vertically) and shares the **same color** as the starting pixel. 
3. Keep **repeating** this process by checking neighboring pixels of the *updated* pixels and modifying their color if it matches the original color of the starting pixel. 
4. The process **stops** when there are **no more** adjacent pixels of the original color to update. 


Return the **modified** image after performing the flood fill. 


**Example 1:**

**Input** 

```
image = [[1, 1, 1], [1, 1, 0], [1, 0, 1]]
sr = 1, 
sc = 1, 
color = 2
```

**Output**

```
[[2, 2, 2], [2, 2, 0], [2, 0, 1]]
```

**Explanation**

| 1   | 1   | 1   |
| --- | --- | --- |
| 1   | 1   | 0   |
| 1   | 0   | 1   |

| 2   | 2   | 2   |
| --- | --- | --- |
| 2   | 2   | 0   |
| 2   | 0   | 1   |

**Example 2:**

**Input**

```
image = [[0, 0, 0], [0, 0, 0]]
sr = 0,
sc = 0,
color = 0
```

**Output**

```
[[0, 0, 0], [0, 0, 0]]
```

**Explanation**




---

# Solution

```java
public int[][] floodFill(int[][] image, int sr, int sc, int color) {
	int originalColor = image[sr][sc];
	if (originalColor == color) return image;
	
	int rows = image.length, cols = image[0].length;
	Queue<int[]> queue = new LinkedList<>();
	queue.add(new int[] {sr, sc});
	image[sr][sc] = newColor;
	
		int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	while (!queue.isEmpty()) {
		int[] cell = queue.poll();
		int r = cell[0], c = cell[1];

		for (int[] d : directions) {
			int nr = r + d[0], nc = c + d[1];
			if (nr >= 0 && nr < rows 
				&& nc >= 0 && image[nr][nc] == originalColor) {
				
				queue.add(new int[] {nr, nc});
				image[nr][nc] = newColor;
			}
		}
	}
	
	return image;    
}
```





