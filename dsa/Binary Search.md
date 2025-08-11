---
aliases:
  - BS
tags:
  - "#algorithm"
published on: 2025-05-26
reviewed: true
revised: 
mastered:
---

# Binary Search

#analogy 
*Imagine you're looking for a word in the dictionary. 
Do you start from page 1? 
Not really, until the word is something like 'aardvark' - you're lucky.
You'd ideally partition the pages and check a few words on the current page.
Depending on whether the word you're looking for happens to occur before or after the current page, 

- *you'd pick the first half, if the word you're looking for is before the series words on the current page alphabetically,* 
*or* 
- *you'd pick the second half, if the word you're looking for is after the series of words on the current page alphabetically.*


Just like you'd skip half the dictionary when searching, Binary Search applies the same logic—but with numbers instead of words. 
We take two pointers `low` and `high`. We use `mid` as an index which will enable us to make an accurate partition as well as return the `target` we're looking for. 

---

Let's consider this example: 

Given array `arr` , our goal is to find the index at which the `target` , let's suppose the target `33`.

| i        | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   |
| -------- | --- | --- | --- | --- | --- | --- | --- | --- |
| arr\[i\] | - 1 | 2   | 4   | 8   | 11  | 21  | 33  | 47  |

**Step 1: Initialize `low` and `high` indices.** 

Initially we set, 
- `low` at the start of the array at index `0`. 
- `high` at the end of the array at index `n - 1` i.e. `7`,
	where `n` is size of the array.

---

**Step 2: Check Mid**

We use the formula `low + (high - low) / 2` to calculate the midpoint instead of `(low + high) / 2`, to avoid [[Integer Flow]].

`low + (high - low) / 2`  
= `0 + (7 - 0) / 2`  
= `0 + 7 / 2`  
= `0 + 3`  
= `3`

| i        | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7   |
| -------- | --- | --- | --- | --- | --- | --- | --- | --- |
| arr\[i\] | - 1 | 2   | 4   | 8   | 11  | 21  | 33  | 47  |
We found that `mid` is 3.
The element at index 3 is 8. 
It's not equal to the target, we move to the next step. Step 3. 

---
 **Step 3: Search Right**

If `arr[mid] <= target` this means our target is greater than the element at `mid`.
If our `target` is greater than `arr[mid]` means, it should be in the right half of the array with respect to `mid` index: 


|          | low |     |     | mid |     |     |     | high |
| -------- | --- | --- | --- | --- | --- | --- | --- | ---- |
| i        | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7    |
| arr\[i\] | - 1 | 2   | 4   | 8   | 11  | 21  | 33  | 47   |


We shift our `low` index to a position `mid + 1`, in this way we'll only be searching in the right half of the array. 
Therefore, our new `low` is `mid + 1` i.e. `3 + 1` which is equal to `4`.

|          | low |     |     | high |
| -------- | --- | --- | --- | ---- |
| i        | 4   | 5   | 6   | 7    |
| arr\[i\] | 11  | 21  | 33  | 47   |

If our `arr[mid]` was strictly greater than the target, it implies that our element should be in the right half, we execute Step 4. 
In our case, it's not, we go step 5.

---
**Step 4: Search Left**

If the element at `mid` index happens to be greater than `target`, it's safe to say that `target` is lesser than `arr[mid]`, therefore we move the search to the left half only.

Consider this example, let's suppose our target is equal to `4`.

|          | low |     |     | mid |     |     |     | high |
| -------- | --- | --- | --- | --- | --- | --- | --- | ---- |
| i        | 0   | 1   | 2   | 3   | 4   | 5   | 6   | 7    |
| arr\[i\] | - 1 | 2   | 4   | 8   | 11  | 21  | 33  | 47   |

As `arr[mid]` is 8 and is greater than `4`, we change our `high` index to `mid - 1`.

Therefore, the new `high` index will be `mid - 1` = `3 - 1` = `2`.

|          | low |     | high |
| -------- | --- | --- | ---- |
| i        | 0   | 1   | 2    |
| arr\[i\] | - 1 | 2   | 4    |

#insight💡 

> *Although `arr[high]` holds the value of our `target` (which is `4` in this case), we don't return it immediately because doing so is redundant from a complexity standpoint and offers negligible performance gain.*

---
**Step 5: Recalculate Mid**

In order to make our search range shorter we updated `high` and `low` indices, similarly we update `mid` using the same formula in Step 2.


Let's go back to the example in Step 2.

|          | low |     |     | high |
| -------- | --- | --- | --- | ---- |
| i        | 4   | 5   | 6   | 7    |
| arr\[i\] | 11  | 21  | 33  | 47   |

We re-iterate Step 2, to find the new `mid` index.

`low` = `4`
`high` = 7

Therefore, 
	`mid` = `low + (high - low) / 2`
		= `4 + (7 - 4) / 2`
		=  `4 + 3 / 2` 
		= `4 + 1` = `5`


|          | low | mid |     | high |
| -------- | --- | --- | --- | ---- |
| i        | 4   | 5   | 6   | 7    |
| arr\[i\] | 11  | 21  | 33  | 47   |

We check if `arr[mid]` == `target` i.e. if 21 == 33, it's not, we move to Step 3.

At Step 3,
we check if `arr[mid] <= target` i.e. `21 <= 33`, which is `true`.

We go back to Step 2, 
Now, the new `low` index will be `mid + 1` i.e. `5 + 1` = `6`

|          | low |     | mid | high |
| -------- | --- | --- | --- | ---- |
| i        | 4   | 5   | 6   | 7    |
| arr\[i\] | 11  | 21  | 33  | 47   |

We check if `arr[mid]` == `target` i.e. if `arr[6] == 33`, it's a match! We return, `mid` as per Step 2. 
The answer is `6`

---

**Step 6: Handle Not Found**  

`return -1`

> *If the loop ends and we still haven’t found the target, that means it’s not in the array. In that case, we return -1 (or throw an exception depending on context).*

---


### #observations👁️ 

1. Step 2, Step 3 or Step 4 and Step 5 are performed repeatedly.
2. These steps needs a loop.
3. The optimal choice would be a `while` loop.
4. We can observe that if the element was never found, we'd be reducing our range until the last element. At this position, `high == low == mid`, if in this final iteration a match to our `target` is not found, we'd be executing Step 7. 
5. Since, the range is defined by `low` and `high` indices and doesn't directly depend on the derived index `mid`, we limit our `while` loop to the condition: `low <= right`.


## Code

Java: 

```java
public int search(int[] arr, int target) {
	int low = 0, int high = arr.length - 1;

	while (low <= high) {
		int mid = low + (high - low) / 2;

		if (arr[mid] == target) return mid; // our match, 33.

		if (arr[mid] < target) {   // target is bigger than current `mid`
			low = mid + 1;
		} else {                  // target is smaller than current `mid`
			high = mid - 1;
		}
	}

	return -1; // if we don't find a match.
}
```


## Complexity

#### Time Complexity

Since, after each iteration our range of query reduces by almost half of the size of array, we end up performing half of the amount of operations. 
This means, [[Binary Search]] algorithm is logarithmic: $$O(log n)$$
#### Space Complexity

We don't use extra space, so our space complexity is constant. $$O(1)$$

#tldr

- Use two pointers (`low`, `high`) 
- Find mid: `mid = low + (high - low) / 2` 
- If `arr[mid] == target`, return `mid` - If `arr[mid] < target`, search right: `low = mid + 1` 
- If `arr[mid] > target`, search left: `high = mid - 1` 
- Repeat until found or `low > high`