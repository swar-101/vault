# Problems

1. **Filtering & Mapping Basics**  
   *Problem:* Given a list of integers, filter out odd numbers and then square each even number.  
   *Focus:* `filter()`, `map()`, and lambda expressions.

2. **Converting & Collecting**  
   *Problem:* Convert a list of strings to uppercase and collect the results into a new list.  
   *Focus:* `map()` and `collect(Collectors.toList())`.

3. **Flattening Nested Structures**  
   *Problem:* Given a list of lists of integers, use `flatMap()` to produce a single flattened list.  
   *Focus:* `flatMap()` for stream flattening.

4. **Reduce for Aggregation**  
   *Problem:* Compute the product of all numbers in a list using `reduce()`.  
   *Focus:* `reduce()` as a terminal operation.

5. **Grouping Elements**  
   *Problem:* Group a list of strings by their first character.  
   *Focus:* `collect(Collectors.groupingBy(...))`.

6. **Partitioning Data**  
   *Problem:* Partition a list of integers into even and odd numbers using `Collectors.partitioningBy()`.  
   *Focus:* Partitioning collectors.

7. **Custom Sorting**  
   *Problem:* Sort a list of custom objects (e.g., employees by age and then name) using streams.  
   *Focus:* `sorted()` with custom comparators.

8. **Pagination with Limit and Skip**  
   *Problem:* Given a large list, implement a basic pagination system using `skip()` and `limit()`.  
   *Focus:* Controlling stream window views.

9. **Removing Duplicates**  
   *Problem:* Remove duplicate elements from a list of strings while preserving order.  
   *Focus:* `distinct()`.

10. **Short-Circuiting Operations**  
    *Problem:* Use `anyMatch()`, `allMatch()`, and `noneMatch()` to test conditions on a collection.  
    *Focus:* Short-circuiting terminal operations.

11. **Handling Optional Results**  
    *Problem:* From a stream of integers, find the first element greater than a given value and handle the case when none is found.  
    *Focus:* `findFirst()` and `Optional`.

12. **Debugging with Peek**  
    *Problem:* Insert a `peek()` call in a stream pipeline to log intermediate values when processing a list of numbers.  
    *Focus:* Using `peek()` for debugging purposes.

13. **Infinite Streams**  
    *Problem:* Create an infinite stream of random numbers using `Stream.generate()` and limit it to 20 elements.  
    *Focus:* Infinite streams and limiting.

14. **Custom Collector**  
    *Problem:* Write a custom collector that accumulates stream elements into a custom data structure (e.g., a summary object).  
    *Focus:* `Collector.of()` for custom collection.

15. **Mapping to Maps**  
    *Problem:* Convert a list of objects (like employees) to a map keyed by a unique identifier.  
    *Focus:* `collect(Collectors.toMap())`.

16. **Combining Multiple Operations**  
    *Problem:* Chain several stream operations (filter, map, sorted, and reduce) to compute a statistical summary (like the sum of squared even numbers).  
    *Focus:* End-to-end pipeline design.

17. **Parallel Streams and Performance**  
    *Problem:* Compare processing time of a CPU-intensive operation on a large collection using sequential and parallel streams.  
    *Focus:* Understanding parallel streams and thread-safety issues.

18. **Exception Handling in Streams**  
    *Problem:* Process a stream of file paths to read file contents, handling checked exceptions within the lambda.  
    *Focus:* Strategies for handling checked exceptions in streams.

19. **Conditional Mapping**  
    *Problem:* For a list of mixed-type objects (or a list with potential nulls), use `map()` and `filter()` to safely transform and filter the data.  
    *Focus:* Null-safety and conditional operations.

20. **Demonstrating Lazy Evaluation**  
    *Problem:* Create a stream pipeline where intermediate operations are “lazy” (e.g., use logging in a `peek()`) and show that nothing happens until a terminal operation is invoked.  
    *Focus:* Understanding stream evaluation and execution order.

