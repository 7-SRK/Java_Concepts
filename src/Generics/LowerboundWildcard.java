package Generics;

import java.util.*;

//Lower Bounded Wildcard: <? super T>
//Represents a type that is either T or a supertype of T.
// Used when you want to write to a collection.

class Animal1 {
    public void sound() {
        System.out.println("Animal sound");
    }
}

class Dog1 extends Animal1 {
    public void sound() {
        System.out.println("Dog barks");
    }
}


public class LowerboundWildcard {
    public static void addDog(List<? super Dog1> animals) {
        animals.add(new Dog1());
    }

    public static void main(String[] args) {
        List<Animal1> animalList = new ArrayList<>();
        addDog(animalList);

        for (Object obj : animalList) {
            ((Animal1) obj).sound();
        }
    }
}
