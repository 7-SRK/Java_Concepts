package Collections;

import java.util.*;

public class Treemap {
    public static void main(String[] args) {
        TreeMap<Integer, String> map = new TreeMap<>();

        map.put(3,"C");
        map.put(4,"D");
        map.put(1,"A");
        map.put(2,"B");

        System.out.println(map);

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
