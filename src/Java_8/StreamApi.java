package Java_8;

//The Java Stream API, introduced in Java 8, allows you to process collections of data in a functional style.
// A stream represents a sequence of elements supporting various operations to perform computations declaratively and efficiently.

//map()
//Purpose: Transforms each element in the stream by applying a function.

//filter()
//Purpose: Selects elements that match a given predicate (condition).

//reduce()
//Purpose: Combines elements of the stream into a single result using an associative function.

import java.util.*;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(4,5,6,1,2,3);

//        Stream<Integer> s = nums.stream();
//        Stream<Integer> s1 = s.filter(n -> n%2==0);
//        Stream<Integer> s2 = s1.map(n-> n*2);
          Stream<Integer> sortedValues = nums.stream()
                           .sorted();

          sortedValues.forEach(n-> System.out.println(n));
//        int result = s2.reduce(0,(c,e)->c+e);
//        s2.forEach(n-> System.out.println(n));


//        int result = nums.stream()
//                    .filter(n -> n%2==0)
//                    .map(n -> n*2)
//                    .reduce(0,(c,e)->c+e);
//
//        System.out.println(result);
    }
}
