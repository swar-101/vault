# 20 Practice Problems to Make You a Stream Machine 🔥

> 🧠 **Note:** Each problem comes with a *Goal*—because knowing what you're trying to get out of a problem matters. This isn't just practice for the sake of it. The idea is to build real, usable intuition around streams—one concept at a time.

1. Open `/problems/src` in a new tab.
2. Go to `Problems.java` file. 
3. Download raw file or copy the contents.
4. Paste in your local IDE.
5. Each problem has its own `main()` method—start by reading the problem statements below 👇 and then begin 
experimenting!

---



1. **Filtering & Mapping Basics**  
   *Problem:* Given a list of integers, filter out odd numbers and then square each even number.  
   *Goal:* Practice `filter()`, `map()`, and lambda expressions.

2. **Converting & Collecting**  
   *Problem:* Convert a list of strings to uppercase and collect the results into a new list.  
   *Goal:* Use `map()` and `collect(Collectors.toList())`.

3. **Flattening Nested Structures**  
   *Problem:* Given a list of lists of integers, use `flatMap()` to produce a single flattened list.  
   *Goal:* Master `flatMap()` for flattening nested data.

4. **Reduce for Aggregation**  
   *Problem:* Compute the product of all numbers in a list using `reduce()`.  
   *Goal:* Use `reduce()` as a terminal operation for aggregation.

5. **Grouping Elements**  
   *Problem:* Group a list of strings by their first character.  
   *Goal:* Apply `Collectors.groupingBy(...)` to categorize data.

6. **Partitioning Data**  
   *Problem:* Partition a list of integers into even and odd numbers using `Collectors.partitioningBy()`.  
   *Goal:* Learn partitioning strategies for binary splits.

7. **Custom Sorting**  
   *Problem:* Sort a list of custom objects (e.g., employees by age and then name) using streams.  
   *Goal:* Build custom comparators and use `sorted()` fluently.

8. **Pagination with Limit and Skip**  
   *Problem:* Given a large list, implement a basic pagination system using `skip()` and `limit()`.  
   *Goal:* Understand stream slicing and pagination.

9. **Removing Duplicates**  
   *Problem:* Remove duplicate elements from a list of strings while preserving order.  
   *Goal:* Use `distinct()` to filter out duplicates.

10. **Short-Circuiting Operations**  
    *Problem:* Use `anyMatch()`, `allMatch()`, and `noneMatch()` to test conditions on a collection.  
    *Goal:* Apply short-circuiting terminal operations.

11. **Handling Optional Results**  
    *Problem:* From a stream of integers, find the first element greater than a given value and handle the case when none is found.  
    *Goal:* Explore `findFirst()` and `Optional` gracefully.

12. **Debugging with Peek**  
    *Problem:* Insert a `peek()` call in a stream pipeline to log intermediate values when processing a list of numbers.  
    *Goal:* Use `peek()` to inspect and debug streams.

13. **Infinite Streams**  
    *Problem:* Create an infinite stream of random numbers using `Stream.generate()` and limit it to 20 elements.  
    *Goal:* Generate and control infinite streams.

14. **Custom Collector**  
    *Problem:* Write a custom collector that accumulates stream elements into a custom data structure (e.g., a summary object).  
    *Goal:* Create a `Collector.of()` for tailored aggregation.

15. **Mapping to Maps**  
    *Problem:* Convert a list of objects (like employees) to a map keyed by a unique identifier.  
    *Goal:* Use `Collectors.toMap()` for transformation.

16. **Combining Multiple Operations**  
    *Problem:* Chain several stream operations (filter, map, sorted, and reduce) to compute a statistical summary (like the sum of squared even numbers).  
    *Goal:* Design an end-to-end stream pipeline.

17. **Parallel Streams and Performance**  
    *Problem:* Compare processing time of a CPU-intensive operation on a large collection using sequential and parallel streams.  
    *Goal:* Explore performance gains (and caveats) with parallelism.

18. **Exception Handling in Streams**  
    *Problem:* Process a stream of file paths to read file contents, handling checked exceptions within the lambda.  
    *Goal:* Learn exception strategies inside lambdas.

19. **Conditional Mapping**  
    *Problem:* For a list of mixed-type objects (or a list with potential nulls), use `map()` and `filter()` to safely transform and filter the data.  
    *Goal:* Master null-safe and conditionally aware mapping.

20. **Demonstrating Lazy Evaluation**  
    *Problem:* Create a stream pipeline where intermediate operations are “lazy” (e.g., use logging in a `peek()`) and show that nothing happens until a terminal operation is invoked.  
    *Goal:* Understand the lazy nature of streams and execution order.
