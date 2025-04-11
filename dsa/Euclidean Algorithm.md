# Euclidean Algorithm in Java

## Overview

The **Euclidean Algorithm** is a classic method for finding the **Greatest Common Divisor (GCD)** of two integers. Its efficiency lies in repeatedly replacing the larger number with the remainder of dividing it by the smaller number, until one of the numbers becomes zero.

> **Fun Fact:** Even though the algorithm is ancient, it still helps modern computers crunch numbers like a champ!

## How It Works

1. **Base Case:** If `m` divides `n` evenly (i.e., `n % m == 0`), then `m` is the GCD.
    
2. **Iteration:** Otherwise, replace `n` with `m` and `m` with `n % m`.
    
3. **Repeat:** Continue the process until `m` becomes 0.
    
4. **Result:** When `m` is 0, `n` contains the GCD.
    

## Java Implementation

```java
public class EuclideanAlgorithm {

    /**
     * Computes the Greatest Common Divisor (GCD) of two numbers using the Euclidean algorithm.
     * Assumes n >= m.
     *
     * @param n the larger number
     * @param m the smaller number
     * @return the GCD of n and m
     */
    public static int gcd(int n, int m) {
        // If m divides n completely, m is the GCD
        if (n % m == 0) {
            return m;
        }
        // Ensure n is always greater than or equal to m
        if (n < m) {
            int temp = n;
            n = m;
            m = temp;
        }
        // Use the Euclidean algorithm iteratively
        while (m != 0) {
            int temp = n % m;
            n = m;
            m = temp;
        }
        return n;
    }

    public static void main(String[] args) {
        int num1 = 56;
        int num2 = 42;
        System.out.println("GCD of " + num1 + " and " + num2 + " is " + gcd(num1, num2));
    }
}
```

## Complexity Analysis

- **Time Complexity:** O(log n)  

The Euclidean Algorithm has logarithmic time complexity, making it very efficient even for large numbers.
_(Tight bound: Θ(log n))_
    
- **Space Complexity:** O(1)  
    It uses a constant amount of extra space.