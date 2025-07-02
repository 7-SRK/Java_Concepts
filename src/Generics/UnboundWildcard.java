package Generics;

import java.util.*;

// Java generics, a wildcard is represented by the question mark ? and denotes an unknown type.
// It allows you to write flexible and reusable code by specifying that a method or variable
// can operate on a generic type without knowing the exact type.

//Unbounded Wildcard: <?>
//Represents any type. Used when you don’t care about the type.

public class UnboundWildcard {
    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.println(elem);
        }
    }

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);

        List<String> strList = new ArrayList<>();
        strList.add("Hello");
        strList.add("World");

        System.out.println("Integer List:");
        printList(intList);

        System.out.println("String List:");
        printList(strList);
    }
}
