package src;

import src.model.Employee;
import src.model.StatisticSummary;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.*;

public class Solutions {


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
                .generate(
                        () -> new Random().nextInt(30)
                )
                .limit(10)
                .toList();

        // src.Solution:
        List<Integer> evenNumbersSquared = integers
                .stream()
                .filter(integer -> integer % 2 == 0)
                .map(evenInteger -> evenInteger * evenInteger)
                .toList();

        // Test:
        public static void main(String[] args) {
            FilteringAndMappingBasics instance = new FilteringAndMappingBasics();
            System.out.println("INPUT:");
            System.out.println(instance.integers);
            System.out.println("OUTPUT:");
            System.out.println(instance.evenNumbersSquared);
        }
    }

    // 2. Converting and Collecting
    // "Convert a list of strings to uppercase and collect the results into a new list."
    static class ConvertingAndCollecting {
        List<String> strings = List.of("visca", "el", "barca", "mes", "que", "club");

        // src.Solution:
        List<String> upperCaseStrings = strings
                .stream()
                .map(String::toUpperCase)
                .toList();

        // Test:
        public static void main(String[] args) {
            ConvertingAndCollecting instance = new ConvertingAndCollecting();
            System.out.println("INPUT:");
            System.out.println(instance.strings);
            System.out.println("OUTPUT:");
            System.out.println(instance.upperCaseStrings);
        }
    }


    // Flattening Nested Structures
    // Given a list of lists of integers, use `flatMap` to produce a single flattened List.
    static class FlatteningNestedStructure {
        List<List<Integer>> integerLists = Stream
                .generate(
                        () -> Stream.generate(() -> new Random().nextInt(100))
                                .limit(2)
                                .toList()
                )
                .limit(5)
                .toList();


        // src.Solution:
        List<Integer> flattenedList = integerLists.stream().flatMap(Collection::stream).toList();

        // Test:
        public static void main(String[] args) {
            FlatteningNestedStructure instance = new FlatteningNestedStructure();
            System.out.println("INPUT:");
            System.out.println(instance.integerLists);
            System.out.println("OUTPUT:");
            System.out.println(instance.flattenedList);
        }
    }

    // 4. Reduce for Aggregation
    // "Compute the product of all numbers in a list."

    static class ReduceForAggregation {
        List<Integer> integers = List.of(1, 3, 4, 3, 2);

        // src.Solution:
        Integer product = integers
                .stream()
                .reduce(1,
                        (product, element) -> product * element
                );

        // Test:
        public static void main(String[] args) {
            ReduceForAggregation instance = new ReduceForAggregation();
            System.out.println("INPUT:");
            System.out.println(instance.integers);
            System.out.println("OUTPUT:");
            System.out.println(instance.product);
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
        Map<Character, List<String>> listGroupedByFirstCharacter = list.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));

        // Test:
        public static void main(String[] args) {
            GroupingElements instance = new GroupingElements();
            System.out.println("INPUT:");
            System.out.println(instance.list);
            System.out.println("OUTPUT:");
            System.out.println(instance.listGroupedByFirstCharacter);
        }
    }


    // 6. Partition a list of elements into even and odd numbers using `Collectors.partitionBy`
    static class PartitioningData {
        List<Integer> integers = Stream
                .generate(
                        () -> new Random().nextInt(100)
                )
                .limit(10)
                .toList();

        // src.Solution:
        Map<Boolean, List<Integer>> partitionedEvenIntegers = integers
                .stream()
                .collect(Collectors.partitioningBy(integer -> integer % 2 == 0));

        // Test:
        public static void main(String[] args) {
            PartitioningData instance = new PartitioningData();
            System.out.println("INPUT:");
            System.out.println(instance.integers);
            System.out.println("OUTPUT:");
            System.out.println("\tPartitioned Even Integers: " + instance.partitionedEvenIntegers.get(true));
            System.out.println("\tPartitioned Odd Integers: " + instance.partitionedEvenIntegers.get(false));
        }
    }


    // 7. Custom Sorting
    // "Sort a list of custom objects"
    static class CustomSorting {

        // src.Solution:
        List<Employee> employeesSortedByName = employees
                .stream()
                .sorted(Comparator.comparing(Employee::name))
                .toList();

        List<Employee> employeeSortedByAge = employees
                .stream()
                .sorted(Comparator.comparing(Employee::age))
                .toList();

        List<Employee> employeeSortedByBirthYear = employees
                .stream()
                .sorted(Comparator.comparing(Employee::birthYear))
                .toList();

        // Test:
        public static void main(String[] args) {
            CustomSorting instance = new CustomSorting();
            System.out.println("INPUT:");
            System.out.println(employees);
            System.out.println("OUTPUT:");
            System.out.println(instance.employeeSortedByAge);
            System.out.println(instance.employeesSortedByName);
            System.out.println(instance.employeeSortedByBirthYear);
        }
    }

    // 8. Pagination with Limit and Skip
    // "Given a large list implement a basic pagination system using `skip()` and `limit()`"
    static class PaginationWithLimitAndSkip {
        private static final long NUMBER_OF_ENTRIES = 1003;
        List<String> usernames = Stream.generate(() -> "user_" + UUID.randomUUID()).limit(NUMBER_OF_ENTRIES).toList();

        // src.Solution:
        private List<String> paginateUsernames(long pageNumber, long pageSize) {
            if (pageSize <= 0) {
                System.err.println("The page size cannot be zero.");
                return Collections.emptyList();
            }
            if (pageNumber <= 0) {
                System.err.println("The page must be greater than zero.");
                return Collections.emptyList();
            }
            if (NUMBER_OF_ENTRIES <= 0) {
                System.err.println("The number of entries must be greater than 0.");
                return Collections.emptyList();
            }
            if (pageSize > NUMBER_OF_ENTRIES) {
                System.out.println("[WARN] The pageSize exceeds the total Number of entries. " +
                        "Adjusting pageSize to number of entries available on a single page.");
                pageSize = NUMBER_OF_ENTRIES;
                pageNumber = 1;
            }

            long totalPages = (NUMBER_OF_ENTRIES + pageSize - 1) / pageSize;

            if (pageNumber > totalPages) {
                System.err.println("The page number exceeds the number of pages.");
                return Collections.emptyList();
            }


            // Calculate actual items on the page
            long startIdx = (pageNumber - 1) * pageSize;
            long endIdx = Math.min(NUMBER_OF_ENTRIES, startIdx + pageSize);
            long actualEntriesOnPage = endIdx - startIdx;

            System.out.printf("[INFO] Showing page %d out of %d page(s). Displaying %d entry/entries out of %d " +
                    "entry/entries.%n", pageNumber, totalPages, actualEntriesOnPage, NUMBER_OF_ENTRIES);

            return usernames
                    .stream()
                    .skip((pageNumber - 1) * pageSize)
                    .limit(pageSize).toList();
        }

        // Test:
        public static void main(String[] args) {
            PaginationWithLimitAndSkip instance = new PaginationWithLimitAndSkip();
            System.out.println("INPUT:");
            System.out.println(instance.usernames);
            System.out.println("OUTPUT:");
            // Positive scenario:
            List<String> paginatedUsernames = instance.paginateUsernames(5, 10);
            System.out.println(paginatedUsernames);

            // Negative scenarios:
            // 1. When `pageNumber` is 0
            List<String> paginatedUsernamesWithZeroPageNumber = instance.paginateUsernames(0, 10);
            System.out.println(paginatedUsernamesWithZeroPageNumber);
            // 2. When `pageSize` is 0
            List<String> paginatedUsernamesWithZeroPageSize = instance.paginateUsernames(10, 0);
            System.out.println(paginatedUsernamesWithZeroPageSize);
            // 3. When `pageNumber` is invalid
            List<String> paginatedUsernamesWithInvalidPageNumber = instance
                    .paginateUsernames(543, 15);

            System.out.println(paginatedUsernamesWithInvalidPageNumber);

            // 4. When `pageSize` is more than the entries available.
            List<String> paginatedUserNamesWithPageSizeMoreThanEntries = instance
                    .paginateUsernames(3, 2000);
            System.out.println(paginatedUserNamesWithPageSizeMoreThanEntries);
        }
    }

    // 9. Removing duplicates
    // "Remove duplicate elements from a list of strings while preserving order."
    static class RemovingDuplicates {
        List<String> words = List.of("If", "if", "I", "had", "a", "gun", "I'll",
                "shoot", "a", "hole", "into", "the", "Sun", "sun");

        // src.Solution:
        List<String> deduplicatedWords = words.stream().distinct().toList();

        // Test:
        public static void main(String[] args) {
            RemovingDuplicates instance = new RemovingDuplicates();
            System.out.println("INPUT:");
            System.out.println(instance.words);
            System.out.println("OUTPUT:");
            System.out.println(instance.deduplicatedWords);
        }
    }


    // 10. Short-Circuiting operations
    // "Use anyMatch(), allMatch(), and noneMatch() to test conditions on a collection."
    // Following is the list of prices of products, answer if
    // 1. Are there any products above $10,000?
    // 2. Are all products priced above $500?
    // 3. Are there no products priced below $100?
    static class ShortCircuitingOperations {
        List<Integer> productPrices = List.of(799, 1299, 9999, 14999, 499, 6999, 899);

        // src.Solution:
        // 1.
        boolean anyProductAbove10k = productPrices.stream().anyMatch(price -> price > 10000);
        // 2.
        boolean isAllProductsAbove500 = productPrices.stream().allMatch(price -> price > 500);
        // 3.
        boolean isAnyProductBelow100 = productPrices.stream().noneMatch(price -> price < 100);

        // Test:
        public static void main(String[] args) {
            ShortCircuitingOperations instance = new ShortCircuitingOperations();
            System.out.println("INPUT:");
            System.out.println(instance.productPrices);
            System.out.println("OUTPUT:");
            System.out.println("Are there any products prices above $10000? " + instance.anyProductAbove10k);
            System.out.println("Are all products prices above $500? " + instance.isAllProductsAbove500);
            System.out.println("Are there no products priced below $100? " + instance.isAnyProductBelow100);
        }
    }

    // 11. Handling Optional Results
    // "From a stream of integers, find the first element greater than a given value, and handle the case
    // where none is found."
    static class HandlingOptionalResults {
        List<Integer> integers = List.of(1, 3, 5, 5, 64, 2, 6, 23, 25, -1);
        int givenValue = 23;

        // src.Solution:
        int firstElementGreaterThanGivenValue = integers
                .stream()
                .filter(element -> element > givenValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("A value greater than " + givenValue + " was not found."));

        // Test:
        public static void main(String[] args) {
            HandlingOptionalResults instance = new HandlingOptionalResults();
            System.out.println("INPUT:");
            System.out.println(instance.integers);
            System.out.printf("Given value %d%n", instance.givenValue);
            System.out.println("OUTPUT:");
            System.out.println(instance.firstElementGreaterThanGivenValue);
        }
    }

    // 12. Debugging with Peak
    // "Insert a peek call in stream() pipeline to log intermediate values when processing a list of numbers
    static class DebuggingWithPeek {
        List<Integer> integers = List.of(12, 35, 32, 64, 62, 621, 692, 5239, 45232);

        // src.Solution:
        List<Integer> integersDivisibleByFour = integers
                .stream()
                .peek(integer -> System.out.println("Before filtering: " + integer))
                .filter(integer -> integer % 4 == 0)
                .peek(integer -> System.out.println("After filtering " + integer))
                .toList();

        // Test:
        public static void main(String[] args) {
            DebuggingWithPeek instance = new DebuggingWithPeek();
            System.out.println("INPUT:");
            System.out.println(instance.integers);
            System.out.println("OUTPUT:");
            System.out.println(instance.integersDivisibleByFour);
        }
    }

    // 13. Infinite Streams
    // "Create an infinite stream of random numbers using Stream.generate() and limit it upto 20 numbers
    static class InfiniteStreams {

        // src.Solution:
        List<Integer> streamOf20RandomNumbers = Stream
                .generate(
                        () -> new Random().nextInt(100)
                )
                .limit(20)
                .toList();

        // Test:
        public static void main(String[] args) {
            InfiniteStreams instance = new InfiniteStreams();
            System.out.println("OUTPUT:");
            System.out.println(instance.streamOf20RandomNumbers);
        }
    }

    // 14. Custom Collector
    // "Write a custom collector that accumulates stream elements into a custom data structure (e.g., a summary src.object)"
    // Understand the `src.model.StatisticSummary` class.
    static class CustomCollector {

        // src.Solution:
        // Creating a custom collector
        public static Collector<Integer, StatisticSummary, StatisticSummary> statisticCollector() {
            return Collector.of(
                    StatisticSummary::new,
                    StatisticSummary::accept,
                    (a, b) -> {
                        a.combine(b);
                        return a;
                    },
                    Collector.Characteristics.UNORDERED
            );
        }

        // Test:
        public static void main(String[] args) {
            List<Integer> integers = IntStream.rangeClosed(1, 10).boxed().toList();
            StatisticSummary summary = integers.stream().collect(statisticCollector());
            System.out.println("INPUT:");
            System.out.println(integers);
            System.out.println("OUTPUT:");
            System.out.println(summary);
        }
    }

    // 15. Mapping to Maps
    // "Convert a list of objects (like employees) to a map keyed by a unique identifier."
    static class MappingToMaps {
        // src.Solution:
        AtomicLong counter = new AtomicLong(1);
        Map<Long, Employee> employeeMap = LongStream
                .rangeClosed(1, employees.size())
                .boxed()
                .collect(Collectors.toMap(
                        Long::valueOf,
                        i -> employees.get(i.intValue() - 1)
                ));

        // Test:
        public static void main(String[] args) {
            MappingToMaps instance = new MappingToMaps();
            System.out.println("INPUT:");
            System.out.println(employees);
            System.out.println("OUTPUT:");
            System.out.println(instance.employeeMap);
        }
    }

    // 16. Combining Multiple Operations
    // "Chain several stream operations (filter, map, sorted and reduce) to compute a statistical summary
    // (like the sum of squared even numbers)."
    static class CombiningMultipleOperations {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // src.Solution:
        int evenNumberIntegerSquaredAndSummed = integers
                .stream()
                .peek(System.out::println)
                .filter(integer -> integer % 2 == 0)
                    .map(integer -> integer * integer)
                .peek(System.out::println)
                .reduce(0, Integer::sum);

        // Test:
        public static void main(String[] args) {
            CombiningMultipleOperations multipleOperations = new CombiningMultipleOperations();
            System.out.println("INPUT:");
            System.out.println(multipleOperations.integers);
            System.out.println("OUTPUT:");
            System.out.println(multipleOperations.evenNumberIntegerSquaredAndSummed);
        }
    }

    static class Template {

        // src.Solution:


        // Test:
        public static void main(String[] args) {
            System.out.println("INPUT:");
            System.out.println("OUTPUT:");
        }
    }
}