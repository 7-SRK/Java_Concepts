package Collections;

import java.util.*;

public class Arraylist {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();

        arr.add("D");
        arr.add("E");
        arr.add("F");
        arr.add("A");
        arr.add("B");
        arr.add("C");

        System.out.println(arr);
        System.out.println();

        Collections.sort(arr);
        System.out.println(arr);

        System.out.println(arr.size());
        System.out.println();

        for(String ch : arr)
            System.out.println(ch);
        System.out.println();

        arr.remove("F");
        System.out.println(arr);
        arr.remove(4);
        System.out.println(arr);

        if(arr.contains("A"))
            System.out.println("A in the List");

        int index = arr.indexOf("A");
        System.out.println("A at the Index of " +index);
        int indexh = arr.indexOf("H");
        System.out.println("H at the Index of " +indexh);


        arr.clear();
        System.out.println(arr);

        if(arr.isEmpty())
            System.out.println("Empty");
    }
}
