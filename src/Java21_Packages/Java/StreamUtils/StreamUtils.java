package Java21_Packages.Java.StreamUtils;

import java.util.*;
import java.util.stream.*;

public class StreamUtils {
    public static void main(String[] args) {
        List<String> names = List.of("Abc", "Bcd", "Abcd", "Bcde", "Abcdef");

        //Filter
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .toList();
        System.out.println("Filtered and uppercased names: " + filteredNames);
        System.out.println();

        //Group by length
        Map<Integer, List<String>> groupedByLength = names.stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println("Grouped by length: " + groupedByLength);
        System.out.println();

        //Count
        long countB = names.stream()
                .filter(name -> name.startsWith("B"))
                .count();
        System.out.println("Number of names starting with B: " + countB);
        System.out.println();

        // 4. Use IntStream to sum lengths of all names
        int totalLength = names.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Total length of all names: " + totalLength);
        System.out.println();

        //Find name starting with 'A' using Optional
        Optional<String> anyNameWithA = names.stream()
                .filter(n -> n.startsWith("A"))
                .findAny();
        anyNameWithA.ifPresentOrElse(
                name -> System.out.println("Found name starting with A: " + name),
                () -> System.out.println("No name starting with A found")
        );
        System.out.println();


        //Grouped summary statistics
        IntSummaryStatistics stats = names.stream()
                .mapToInt(String::length)
                .summaryStatistics();
        System.out.println("Max length: " + stats.getMax());
        System.out.println("Min length: " + stats.getMin());
        System.out.println("Average length: " + stats.getAverage());
        System.out.println();

        //Stream.builder
        Stream.Builder<String> builder = Stream.builder();
        builder.add("Java");
        builder.add("Python");
        builder.add("C++");
        Stream<String> languages = builder.build();
        System.out.print("Languages stream: ");
        languages.forEach(lang -> System.out.print(lang + " "));
        System.out.println();

        //Flatten a stream of lists
        List<List<String>> listOLists = List.of(
                List.of("a", "b"),
                List.of("c", "d"),
                List.of("e")
        );
        List<String> flattened = listOLists.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println("Flattened list: " + flattened);
        System.out.println();

        //Parallel stream
        names.parallelStream()
                .filter(n -> n.length() > 3)
                .forEach(name -> System.out.println("Parallel processing: " + name));
        System.out.println();
    }
}
