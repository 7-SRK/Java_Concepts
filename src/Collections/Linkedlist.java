package Collections;

import java.util.*;

public class Linkedlist {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();


        list.add("A");
        list.add("E");
        list.add("C");
        System.out.println(list);

        list.addFirst("D");
        list.addLast("E");
        System.out.println(list);


        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());


        list.removeFirst();
        list.removeLast();
        System.out.println(list);

        System.out.println(list.contains("B"));

        System.out.println("Size of list: " + list.size());

        for(String l : list)
            System.out.println(l);
    }
}
