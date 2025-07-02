package DesignPatterns.StructuralDesignPattern;

import java.util.ArrayList;
import java.util.List;

//The Composite Pattern is a structural design pattern that allows you to compose objects
// into tree-like structures to represent part-whole hierarchies.
// It lets clients treat individual objects and compositions of objects uniformly.

interface Box {
    double getPrice();
}

class Book implements Box {
    private double price;
    public Book(double price) {
        this.price = price;
    }
    @Override
    public double getPrice() {
        return price;
    }
}

class VideoGame implements Box {
    private double price;
    public VideoGame(double price) {
        this.price = price;
    }
    @Override
    public double getPrice() {
        return price;
    }
}



// Composite class
class CompositeBox implements Box {
    private List<Box> items = new ArrayList<>();
    private double packagingCost;

    public CompositeBox(double packagingCost) {
        this.packagingCost = packagingCost;
    }

    public void add(Box item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        double total = packagingCost;
        for (Box item : items) {
            total += item.getPrice();  // Recursive call for composite or leaf
        }
        return total;
    }
}


public class CompositePattern {
    public static void main(String[] args) {
        Book book1 = new Book(10.0);
        VideoGame game1 = new VideoGame(50.0);

        CompositeBox smallBox = new CompositeBox(2.0); // packaging cost 2
        smallBox.add(book1);
        smallBox.add(game1);

        Book book2 = new Book(15.0);
        CompositeBox bigBox = new CompositeBox(5.0); // packaging cost 5
        bigBox.add(smallBox);
        bigBox.add(book2);

        System.out.println("Total price of bigBox: " + bigBox.getPrice());
    }
}
