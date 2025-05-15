## 🗜️ Coordinate Compression

### 📌 Definition

**Coordinate Compression** is a technique used to map large or sparse numeric values to a smaller, continuous range of integers (like `0` to `N-1`) while preserving their **relative order**.

---

### 🚀 Why Use It?

✅ Reduce memory usage  
✅ Make large values usable in arrays, prefix sums, Fenwick Trees, segment trees, etc.  
✅ Preserve the order of elements  
✅ Enable fast range queries and updates

---

### 🧠 Core Idea

> Replace original values with their **sorted position** (or rank) in a deduplicated list.

For example:

```text
Original:   [100, 50000, 9999999]
Sorted:     [100, 50000, 9999999]
Compressed: [  0,     1,       2 ]
```

---

### 🛠️ Steps

1. **Copy & Sort** the original array
    
2. **Deduplicate** the sorted array (optional for strict ranking)
    
3. **Map each original value to its index in the sorted array**. Call this ranking or index mapping depending on the use case. 

    

```java
// Java-style pseudocode
int[] arr = {100, 50000, 9999999};
int[] sorted = sortAndDeduplicate(arr);
Map<Integer, Integer> compressedIndex = new HashMap<>();

for (int i = 0; i < sorted.length; i++) {
    compressedIndex.put(sorted[i], i);
}

// Now, arr[i] is represented as compressedIndex.get(arr[i])
```

---

### 🔥 Use Cases

- 📈 **Prefix sum & frequency counting**
    
- 📊 **Fenwick Trees / BITs**
    
- 🧮 **Segment trees**
    
- 📦 **Inversion count**
    
- 🧠 **Lily and Number 5 problem** (elements divisible by 5 with at least 2 smaller elements)
    

---

### 🧙 Analogy

Think of it like compressing a huge address book of house numbers into flat numbers on a spreadsheet. You care about **position**, not the actual number.

---

### 📁 Save and Reuse

Whenever values are too large but only their **relative comparison** or **frequency** matters → use coordinate compression.


