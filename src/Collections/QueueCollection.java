package Collections;

import java.util.LinkedList;
import java.util.*;

public class QueueCollection {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("A");
        queue.offer("B");
        queue.add("C");
        queue.offer("D");

        System.out.println("Queue: " + queue);


        System.out.println("Head element (element): " + queue.element());
        System.out.println("Head element (peek): " + queue.peek());


        System.out.println("Removed (remove): " + queue.remove());
        System.out.println("Removed (poll): " + queue.poll());

        System.out.println("Queue after removals: " + queue);

        // Search for element
        System.out.println("Contains 'three'? " + queue.contains("three"));
        System.out.println("Contains 'five'? " + queue.contains("five"));

        for (String item : queue) {
            System.out.println(item);
        }
    }
}
