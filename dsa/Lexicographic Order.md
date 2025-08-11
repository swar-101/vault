
It's like how words are ordered in a dictionary.

```plaintext
apple
banana
bat
cat
```


For numbers.

```plaintext
[1]
[1, 2]
[1, 2, 3]
[1, 3]
[2]
[2, 3]
[3]
```


This is **lexicographic** because `[1, 2]` comes before `[1, 3]` and `[1, 2, 3]` comes before `[1, 3]`, and `[1, 2, 3]` comes `[1, 3]`, etc. We achieve this naturally **by sorting the array and building subsets incrementally** from array `[1, 2, 3]`.


