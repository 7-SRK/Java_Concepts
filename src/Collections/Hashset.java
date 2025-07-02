package Collections;

import java.util.*;



public class Hashset {
    public static void main(String[] args) {
        HashSet<String> s = new HashSet<>();
        s.add("A");
        s.add("F");
        s.add("B");
        s.add("C");
        s.add("D");
        s.add("C");
        System.out.println(s);

        for (String se : s)
            System.out.println(se);

        Boolean ret = s.contains("B");
        System.out.println(ret);

        ArrayList<String> list = new ArrayList<>();
        list.add("C");
        list.add("D");

        s.addAll(list);
        System.out.println(s);
    }
}
