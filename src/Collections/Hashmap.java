package Collections;

import java.util.*;

public class Hashmap {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();

        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");
        map.put(4,"D");

        System.out.println(map);

        System.out.print("Keys: ");
        for (Integer key : map.keySet()) {
            System.out.print(key + " ");
        }


        System.out.print("\nValues: ");
        for (String value : map.values()) {
            System.out.print(value + " ");
        }

        System.out.println("\nEntries:");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }
}
