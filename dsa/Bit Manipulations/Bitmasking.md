# Bitmasking

What is bitmasking?  
Bitmasking is a technique which helps us achieve bit manipulations via bitwise operators to achieve the following results:
1. Checking if a bit is present.
2. Setting a bit at a particular position.
3. Clearing a bit at a particular position.
4. Toggling a bit (do it later) 
   
## How to bitmask?

In order to create a bitmask, we need to understand the position we are interested in manipulating. To choose a position, we need to understand the indexing (correct me if I'm wrong) in binary numbers with respect to the bit positions.

Let's say we have `10000` as our binary number.  
The indexing is as follows:

| Index | 4 | 3 | 2 | 1 | 0 |
|:-----:|:-:|:-:|:-:|:-:|:-:|
| Bit   | 1 | 0 | 0 | 0 | 0 |

Let's say we want to change the bit in the middle. We observe that it's at index 2.

We can simply create a bitmask by using the following technique:

```java
int binaryNumber = 0b10000; 
int position = 2;  // index is 2
int bitmask = 1 << position; // 0b100
````

The bitmask we've created is `100`.

Let's explore how we can use this bitmask to manipulate our binary number at position 2.

---

### 1. Checking if a Bit is Present

To check if the bit is present at position 2, we simply use the Bitwise AND `&` operator between the `binaryNumber` and our `bitmask` and check if the result is 0. Why? Because the Bitwise AND operator returns 1 only if there is a 1 at the corresponding position. If the bit is not present (like in our case), the result will be 0, as shown below:

| Operation         | Bit 4 | Bit 3 | Bit 2 | Bit 1 | Bit 0 |
|-------------------|:-----:|:-----:|:-----:|:-----:|:-----:|
| Binary Number     |   1   |   0   |   0   |   0   |   0   |
| Bitmask           |   0   |   0   |   1   |   0   |   0   |
| **Result (AND)**  |   0   |   0   |   0   |   0   |   0   |

Programmatically:
```java
int binaryNumber = 0b10000;
int position = 2;
int bitmask = 1 << position; 

boolean isBitSet = (binaryNumber & bitmask) != 0;  // Check if it's present
System.out.println("Is bit present at position 2? " + isBitSet); // false
```

---

### 2. Setting a Bit

#### What does setting a bit mean?

_(if 0, it becomes 1; if 1, it stays 1)_

To set a bit in our binary number, we ensure that the bit at that position becomes 1. We achieve this by using the Bitwise OR `|` operator, because the OR operator will return 1 whether the bit is already present or not.

| Operation         | Bit 4 | Bit 3 | Bit 2 | Bit 1 | Bit 0 |
|-------------------|:-----:|:-----:|:-----:|:-----:|:-----:|
| Binary Number     |   1   |   0   |   0   |   0   |   0   |
| Bitmask           |   0   |   0   |   1   |   0   |   0   |
| **Result (OR)**   |   1   |   0   |   1   |   0   |   0   |


Programmatically:
```java
int binaryNumber = 0b10000;
int position = 2;
int bitmask = 1 << position; 

binaryNumber |= bitmask; // We set the bit using '|='
System.out.println("The bit is set at position 2: " + Integer.toBinaryString(binaryNumber)); // 0b10100
```

---

### 3. Clearing a Bit

#### What does clearing a bit mean?

_(if 1, it becomes 0; if 0, it stays 0)_

To clear a bit in our binary number, we ensure that the bit at that position becomes 0. We achieve this by using the Bitwise AND `&` operator with a flipped bitmask (flipped using the Bitwise NOT `~` operator). Since our bitmask has a 1 at the position we want to clear, flipping it sets that position to 0 (and all others to 1), so that AND-ing the original number will clear the bit.

| Operation       | Bit 4 | Bit 3 | Bit 2 | Bit 1 | Bit 0 |
| --------------- | :---: | :---: | :---: | :---: | :---: |
| Binary Number   |   1   |   0   |   0   |   0   |   0   |
| Bitmask         |   0   |   0   |   1   |   0   |   0   |
| **Result (OR)** |   1   |   0   |   1   |   0   |   0   |

Programmatically:
```java
int binaryNumber = 0b10000;
int position = 2;
int bitmask = 1 << position;
int flippedBitmask = ~bitmask;

binaryNumber &= flippedBitmask; // We clear the bit using '&='
System.out.println("After clearing bit at position 2: " + Integer.toBinaryString(binaryNumber)); // 0b10000
```

---

## Full Example

Here’s a complete example demonstrating all three operations:
```java
class BitmaskingInAction {
    public static void main(String[] args) {
        int num = 0b1111111; 
        int position = 3;
        int mask = 1 << position; // 0b1000
        
        boolean isBitSet = (num & mask) != 0; // 0b1111111 & 0b0001000
        int setBitResult = num | mask;        // 0b1111111 | 0b0001000
        int clearedBitResult = num & ~mask;   // 0b1111111 & 0b1110111
        
        System.out.println("num ->              " + Integer.toBinaryString(num));
        System.out.println("position ->         " + position);
        System.out.println("mask ->             " + Integer.toBinaryString(mask));
        System.out.println("isBitSet ->         " + isBitSet);
        System.out.println("setBitResult ->     " + Integer.toBinaryString(setBitResult));
        System.out.println("clearedBitResult => " + Integer.toBinaryString(clearedBitResult));
    }
}
```