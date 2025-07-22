
## Binary Tree

Each node has at most 2 children. 

## Binary Search Tree (BST)

Left < Root < Right, always sorted. 



## Node Structure in Java

```java
public class TreeNode {
	int val; 
	TreeNode left; 
	TreeNode right;
	
	public TreeNode(int val) {
		this.val = val; 
	}
}
```




## Recursion 

Every traversal and height/count problem is rooted in recursion. 
1. Base case recognition (`if (root == null) return`)
2. Recursion flow (DFS style: go deep, then pop back up)


## Understanding the 3 Traversals (DFS)

There are 3 ways of visiting nodes: 

| Traversal | Order                 | Real-world analogy                                |
| --------- | --------------------- | ------------------------------------------------- |
| Preorder  | Root -> Left -> Right | Packing boxes (check item, then left, then right) |
| Inorder   | Left -> Root -> Right | BST sorted values, great for printing in order    |
| Postorder | Left -> Right -> Root | Deleting folders (empty subfolders, then folder)  |


