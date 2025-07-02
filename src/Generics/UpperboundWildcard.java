package Generics;

import java.util.*;

//Upper Bounded Wildcard: <? extends T>
//Represents a type that is either T or a subtype of T.
// Used when you want to read from a collection.

class Animal {
    public void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    public void sound() {
        System.out.println("Dog barks");
    }
}

public class UpperboundWildcard {
    public static void makeAnimalsSound(List<? extends Animal> animals) {
        for (Animal a : animals) {
            a.sound();
        }
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        makeAnimalsSound(dogs);
    }
}
