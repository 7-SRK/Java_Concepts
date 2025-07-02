package Collections;

import java.util.*;

//LinkedHashSet is a class in java.util that implements the Set interface.
//It combines the features of HashSet and LinkedList.
//Maintains unique elements (no duplicates allowed).
//Maintains insertion order during iteration (unlike HashSet).

public class LinkedHashset {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        set.add("A");
        set.add("D");
        set.add("B");
        set.add("C");
        set.add("A"); // Duplicate ignored

        System.out.println(set); // Maintains insertion order
    }
}

