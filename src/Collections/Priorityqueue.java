package Collections;

import java.util.*;

//PriorityQueue is a queue data structure in Java that orders its elements according to their
//natural ordering (if elements implement Comparable) or by a custom Comparator provided at queue construction.
//Unlike a regular queue, elements are not processed in FIFO order but based on their priority.

public class Priorityqueue {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();


        pq.add(30);
        pq.add(10);
        pq.add(20);
        pq.offer(40);

        System.out.println("PriorityQueue: " + pq);


        System.out.println("Peek: " + pq.peek());

        for (Integer num : pq) {
            System.out.println(num); // Order not guaranteed
        }
        System.out.println();

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        System.out.println("Poll: " + pq.poll());

        System.out.println("PriorityQueue after polling: " + pq);
    }
}
