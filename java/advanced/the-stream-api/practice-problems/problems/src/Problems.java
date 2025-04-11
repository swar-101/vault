import src.model.Employee;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.*;

public class Problems {

    static List<Employee> employees = List.of(
            new Employee("Sergio Blanco", 31, "1994"),
            new Employee("Mitsuo Yokosuka", 17, "2008"),
            new Employee("Nuno Valente", 33, "1992"),
            new Employee("Caesar Bonucci", 30, "1995"),
            new Employee("Ravi Kumar", 18, "2007"));

    // 1. Filtering and Mapping Basics
    // "Given a list of integers, filter out the odd numbers and then square
    // each even number."
    static class FilteringAndMappingBasics {
        List<Integer> integers = Stream
                .generate(() -> new Random().nextInt(30))
                .limit(10)
                .toList();

        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            FilteringAndMappingBasics instance = new FilteringAndMappingBasics();
            System.out.println("INPUT:");
            System.out.println(instance.integers);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 2. Converting and Collecting
    // "Convert a list of strings to uppercase and collect the results into a new list."
    static class ConvertingAndCollecting {
        List<String> strings = List.of("visca", "el", "barca", "mes", "que", "club");

        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            ConvertingAndCollecting instance = new ConvertingAndCollecting();
            System.out.println("INPUT:");
            System.out.println(instance.strings);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 3. Flattening Nested Structures
    // "Given a list of lists of integers, use `flatMap` to produce a single flattened List."
    static class FlatteningNestedStructure {
        List<List<Integer>> integerLists = Stream
                .generate(() -> Stream.generate(() -> new Random().nextInt(100))
                        .limit(2)
                        .toList())
                .limit(5)
                .toList();

        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            FlatteningNestedStructure instance = new FlatteningNestedStructure();
            System.out.println("INPUT:");
            System.out.println(instance.integerLists);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 4. Reduce for Aggregation
    // "Compute the product of all numbers in a list."
    static class ReduceForAggregation {
        List<Integer> integers = List.of(1, 3, 4, 3, 2);

        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            ReduceForAggregation instance = new ReduceForAggregation();
            System.out.println("INPUT:");
            System.out.println(instance.integers);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 5. Grouping Elements
    // "Group a list of strings by their first character"
    static class GroupingElements {
        List<String> list = List.of("Bratislava", "Malaga CF", "Zenith St. Petersburg", "Rotterdam",
                "Helsinki", "Baku", "Andalusia", "Catalonia", "Mas Que Nada", "Xin Biu", "Venice", "Ponders",
                "Quebec", "Wembley", "Umberto", "Uppsala", "Krankenhaus", "Luma", "Obsidian", "Svetlana",
                "Transylvania", "Veto", "Wunderbar", "Xzbit", "Yamal", "Lamine", "Pedri", "Balde", "Ascension",
                "El Diego", "Lionel", "Gaucho", "Rafa", "Nazario", "Robson", "Kilian", "Musa", "Xi Jin Ping",
                "Vladimir", "Marc", "Caligula", "Augustus", "Claudius", "Epithelium");

        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            GroupingElements instance = new GroupingElements();
            System.out.println("INPUT:");
            System.out.println(instance.list);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 6. Partitioning Data
    // "Partition a list of elements into even and odd numbers using `Collectors.partitioningBy`"
    static class PartitioningData {
        List<Integer> integers = Stream
                .generate(() -> new Random().nextInt(100))
                .limit(10)
                .toList();

        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            PartitioningData instance = new PartitioningData();
            System.out.println("INPUT:");
            System.out.println(instance.integers);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 7. Custom Sorting
    // "Sort a list of custom objects"
    static class CustomSorting {
        // Use the shared employees list from Problems class

        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            CustomSorting instance = new CustomSorting();
            System.out.println("INPUT:");
            System.out.println(employees);
            System.out.println("OUTPUT:");
            // (Your solution output for sorted by age, name, and birth year)
        }
    }

    // 8. Pagination with Limit and Skip
    // "Given a large list implement a basic pagination system using `skip()` and `limit()`"
    static class PaginationWithLimitAndSkip {
        private static final long NUMBER_OF_ENTRIES = 1003;
        List<String> usernames = Stream.generate(() -> "user_" + UUID.randomUUID())
                .limit(NUMBER_OF_ENTRIES)
                .toList();

        // src.Solution:
        // (Write your solution code here to paginate usernames)

        // Test:
        public static void main(String[] args) {
            PaginationWithLimitAndSkip instance = new PaginationWithLimitAndSkip();
            System.out.println("INPUT:");
            System.out.println(instance.usernames);
            System.out.println("OUTPUT:");
            // (Your solution output for various pagination scenarios)
        }
    }

    // 9. Removing Duplicates
    // "Remove duplicate elements from a list of strings while preserving order."
    static class RemovingDuplicates {
        List<String> words = List.of("If", "if", "I", "had", "a", "gun", "I'll",
                "shoot", "a", "hole", "into", "the", "Sun", "sun");

        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            RemovingDuplicates instance = new RemovingDuplicates();
            System.out.println("INPUT:");
            System.out.println(instance.words);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 10. Short-Circuiting Operations
    // "Use anyMatch(), allMatch(), and noneMatch() to test conditions on a collection."
    // Answer these:
    // 1. Are there any products above $10,000?
    // 2. Are all products priced above $500?
    // 3. Are there no products priced below $100?
    static class ShortCircuitingOperations {
        List<Integer> productPrices = List.of(799, 1299, 9999, 14999, 499, 6999, 899);

        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            ShortCircuitingOperations instance = new ShortCircuitingOperations();
            System.out.println("INPUT:");
            System.out.println(instance.productPrices);
            System.out.println("OUTPUT:");
            // (Your solution output for the three conditions)
        }
    }

    // 11. Handling Optional Results
    // "From a stream of integers, find the first element greater than a given value, and handle the case
    // where none is found."
    static class HandlingOptionalResults {
        List<Integer> integers = List.of(1, 3, 5, 5, 64, 2, 6, 23, 25, -1);
        int givenValue = 23;

        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            HandlingOptionalResults instance = new HandlingOptionalResults();
            System.out.println("INPUT:");
            System.out.println(instance.integers);
            System.out.printf("Given value %d%n", instance.givenValue);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 12. Debugging with Peek
    // "Insert a peek call in stream() pipeline to log intermediate values when processing a list of numbers"
    static class DebuggingWithPeek {
        List<Integer> integers = List.of(12, 35, 32, 64, 62, 621, 692, 5239, 45232);

        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            DebuggingWithPeek instance = new DebuggingWithPeek();
            System.out.println("INPUT:");
            System.out.println(instance.integers);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 13. Infinite Streams
    // "Create an infinite stream of random numbers using Stream.generate() and limit it up to 20 numbers"
    static class InfiniteStreams {
        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            InfiniteStreams instance = new InfiniteStreams();
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 14. Custom Collector
    // "Write a custom collector that accumulates stream elements into a custom data structure (e.g., a summary object)"
    // Understand the `StatisticSummary` class.
    static class CustomCollector {
        // src.Solution:
        // (Write your solution code here, possibly using Collector.of for StatisticSummary)

        // Test:
        public static void main(String[] args) {
            List<Integer> integers = IntStream.rangeClosed(1, 10).boxed().toList();
            System.out.println("INPUT:");
            System.out.println(integers);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 15. Mapping to Maps
    // "Convert a list of objects (like employees) to a map keyed by a unique identifier."
    static class MappingToMaps {
        AtomicLong counter = new AtomicLong(1);
        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            MappingToMaps instance = new MappingToMaps();
            System.out.println("INPUT:");
            System.out.println(employees);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 16. Combining Multiple Operations
    // "Chain several stream operations (filter, map, sorted and reduce) to compute a statistical summary
    // (like the sum of squared even numbers)."
    static class CombiningMultipleOperations {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // src.Solution:
        // (Write your solution code here)

        // Test:
        public static void main(String[] args) {
            CombiningMultipleOperations multipleOperations = new CombiningMultipleOperations();
            System.out.println("INPUT:");
            System.out.println(multipleOperations.integers);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 17. Parallel Streams and Performance
    // "Compare processing time of a CPU-intensive operation on a large collection using sequential and parallel
    // streams."
    static class ParallelStreamsAndPerformance {
        // Sample input: A large list of integers
        List<Integer> largeList = IntStream.rangeClosed(1, 1000000).boxed().toList();

        // src.Solution:
        // (Write your solution code here to compare sequential vs parallel processing)

        // Test:
        public static void main(String[] args) {
            ParallelStreamsAndPerformance instance = new ParallelStreamsAndPerformance();
            System.out.println("INPUT:");
            System.out.println("Large list with " + instance.largeList.size() + " elements.");
            System.out.println("OUTPUT:");
            // (Your solution output for performance comparison)
        }
    }

    // 18. Exception Handling in Streams
    // "Process a stream of file paths to read file contents, handling checked exceptions within the lambda."
    static class ExceptionHandlingInStreams {
        // Sample input: A list of file paths (as strings)
        List<String> filePaths = List.of("file1.txt", "file2.txt", "file3.txt");

        // src.Solution:
        // (Write your solution code here to process the file paths and handle exceptions)

        // Test:
        public static void main(String[] args) {
            ExceptionHandlingInStreams instance = new ExceptionHandlingInStreams();
            System.out.println("INPUT:");
            System.out.println(instance.filePaths);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 19. Conditional Mapping
    // "For a list of mixed-type objects (or a list with potential nulls), use map() and filter() to safely transform
    // and filter the data."
    static class ConditionalMapping {
        // Sample input: A list with potential null values
        List<String> mixedData = List.of("Java", null, "Streams", "Parallel", null, "Lambda");

        // src.Solution:
        // (Write your solution code here to handle nulls and conditionally transform the data)

        // Test:
        public static void main(String[] args) {
            ConditionalMapping instance = new ConditionalMapping();
            System.out.println("INPUT:");
            System.out.println(instance.mixedData);
            System.out.println("OUTPUT:");
            // (Your solution output)
        }
    }

    // 20. Demonstrating Lazy Evaluation
    // "Create a stream pipeline where intermediate operations are ‘lazy’ (e.g., use logging in a peek())
    // and show that nothing happens until a terminal operation is invoked."
    static class DemonstratingLazyEvaluation {
        // Sample input: A list of integers
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // src.Solution:
        // (Write your solution code here to demonstrate lazy evaluation using peek() and a terminal operation)

        // Test:
        public static void main(String[] args) {
            DemonstratingLazyEvaluation instance = new DemonstratingLazyEvaluation();
            System.out.println("INPUT:");
            System.out.println(instance.numbers);
            System.out.println("OUTPUT:");
            // (Your solution output to show lazy behavior)
        }
    }
}