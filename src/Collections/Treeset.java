package Collections;

import java.util.*;

//TreeSet is a class in java.util that implements the NavigableSet and SortedSet interfaces.
//It stores unique elements in sorted (natural ascending) order.
//Does not allow null elements (throws NullPointerException if attempted).

public class Treeset {
    public static void main(String[] args) {
        TreeSet<String> s = new TreeSet<>();
        s.add("A");
        s.add("C");
        s.add("D");
        s.add("B");
        s.add("C");
        System.out.println(s);

        for (String se : s)
            System.out.println(se);

        Boolean ret = s.contains("B");
        System.out.println(ret);
    }
}