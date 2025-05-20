Given an array of integers, every element appears thrice except for one, which appears once.
Find the element which does not appear thrice.

> **Problem Constraints:**
>  2 <= |A|  <= 5 x 10<sup>6</sup>
>  0 <= A[i] <= INTMAX

**Input:**
A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]

**Output:**
4

---

### Solution


#### Brute Force: Create a Map to store the frequency of each element, then check the count by iterating over the Map to find the integer whose count is 1


```java
int singleNumber = -1;
Map<Integer, Integer> frequencyMap = new ArrayList<>();
for (int num : A) {
	if (frequencyMap.containsKey(num)) {
		frequencyMap.put(num, frequencyMap.get(num) + 1); 
	}
	frequencyMap.put(num, 1);
}

for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
	if (entry.getValue() == 1) {
		singleNumber = entry.getKey();
		break;
	}
}

return singleNumber; 
```


We can do better than this. We can use Bit Manipulation!

#### Optimized Solution:

We can't use XOR here, as XOR would help us cancel out two repeating integers. What about the third.

We can check how many times each bit is set in all numbers. 
If the count is divisible by 3. This means it's a repeating integer. 
We return the integer which is not divisible by 3. 
et viola!

```java
int result = 0; 

for (int i = 0; i < 32; i++) {
	int bitSum = 0; 
	for (int num : A) {
		if (((num >> i) & 1) == 1) {
			bitSum++;
		}
	}
	if (bitSum % 3 != 0) {
		result |= (1 << i);
	}
}

return result;
```

A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]

**The Inner Loop**

| i   | bitSum | num | num>>i                      | (num >> i) & 1                     | bitSum |
| --- | ------ | --- | --------------------------- | ---------------------------------- | ------ |
| 0   | 0      | 1   | 1 >> 0 = 1                  | 1 & 1 = 1                          | 1      |
| 0   | 0      | 2   | 2>>0 =2                     | 2 & 1 =<br>0b010 & 0b001 = 000     | 1      |
| 0   | 1      | 4   | 4>>0 =4                     | 4 & 1 = <br>0b100 &<br>0b001 = 000 | 1      |
| 0   | 1      | 3   | 3>>0=3                      | 3 & 1 = <br>0b011 &<br>0b001 = 001 | 2      |
| 0   | 2      | 3   | 3>>0=3                      | 3 & 1 = 001                        | 3      |
| 0   | 3      | 2   | 2>>0=2                      | 2 & 1 = <br>0b010<br>0b001 = 000   | 3      |
| 0   | 3      | 2   | 2>>0=2                      | 2&1 = <br>0b010<br>0b001 = 000     | 3      |
| 0   | 3      | 3   | 3>>0 =3                     | 3&1 =<br>0b011<br>0b001 = 1        | 4      |
| 0   | 4      | 1   | 1>>0=1                      | 1&1 = 1                            | 5      |
| 0   | 5      | 1   | 1>>0=1                      | 1&1 = 1                            |        |
| 1   | 5      | 1   | 1>>1 = 0 <br>               | 0 & 1                              | 5      |
| 1   | 5      | 2   | 2>>1 = 1                    | 1 & 1                              | 6      |
| 1   | 6      | 4   | 4>>1 =<br>0b100 =<br>010    | 010 & 1                            | 6      |
| 1   | 6      | 3   | 3>>1 = <br>0b011 = 1        | 1 & 1                              | 7      |
| 1   | 7      | 3   | 3>>1                        | 1 & 1                              | 8      |
| 1   | 8      | 2   | 2>>1 = <br>0b010<br>001     | 1 & 1                              | 9      |
| 1   | 9      | 2   | 2>>1 =<br>0b010 = 1         | 1 & 1                              | 10     |
| 1   | 10     | 3   | 3>>1 =<br>0b011<br>= 1      | 1 & 1                              | 11     |
| 1   | 11     | 1   | 1>>1 = 0                    | 0 & 1                              | 11     |
| 1   | 11     | 1   | 1>>1=0                      | 0 & 1                              | 11     |
| 2   | 11     | 1   | 1>>1=0                      | 0 & 1                              | 11     |
| 2   | 11     | 2   | 2>>1 = 1<br>0b010<br>= 1    | 1 & 1                              | 12     |
| 2   | 12     | 4   | 4>>1 = <br>0b100 =<br>0b010 | 2 & 1                              | 12     |
| 2   | 12     | 3   | 3>>1 =<br>0b011 =<br>0b 001 | 1 & 1                              | 13     |
| 2   | 13     | 3   | 3>>1 = 1                    | 1 & 1                              | 14     |
| 2   | 14     | 2   | 2 >> 1 = 0b010<br>= 0b001   | 1 & 1                              | 15     |
| 2   | 15     | 2   | 2 >> 1 = 0b010<br>= 1       | 1 & 1                              | 16     |
| 2   | 16     | 3   | 3>>1 = 1                    | 1 & 1                              | 17     |
| 2   | 17     | 1   | 1>>1 = 0                    | 0 & 1                              | 17     |
| 2   | 17     | 1   | 1>>1 = 0                    | 0 & 1 = 0                          | 17     |


| bitSum%3!=0 | result | = (1 << i) |
| ----------- | ------ | ---------- |
|             |        |            |
|             |        |            |
|             |        |            |
|             |        |            |
|             |        |            |
