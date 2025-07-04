package DesignPatterns.BehavioralDesignPattern;

import java.util.*;

//The Iterator Pattern is a behavioral design pattern that provides a way to access the elements
// of a collection sequentially without exposing its underlying representation.
// It encapsulates the traversal logic inside a separate iterator object,
// allowing multiple iterators to traverse the same collection independently.

// Iterator interface
interface U {
    boolean hasNext();
    String next();
}

// Aggregate interface
interface V {
    U createIterator();
}

// Concrete Aggregate (Collection)
class W implements V {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public U createIterator() {
        return new X(items);
    }
}

// Concrete Iterator
class X implements U {
    private List<String> items;
    private int position = 0;

    public X(List<String> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            return null;
        }
        return items.get(position++);
    }
}

// Client
public class IteratorPattern {
    public static void main(String[] args) {
        W collection = new W();
        collection.addItem("A");
        collection.addItem("B");
        collection.addItem("C");

        U iterator = collection.createIterator();

        System.out.println("Iterating over collection:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

