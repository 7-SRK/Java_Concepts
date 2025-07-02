package DesignPatterns.CreationalDesignPattern;

//It allows creating a copy (clone) of an existing object.
//
//The cloning process is delegated to the object itself,
// avoiding tight coupling to concrete classes.
//
//Useful when you don't know the exact class of the object you want to copy
// or when creating an object is expensive.

interface Prototype {
    Prototype clone();
}

class Cars implements Prototype {
    private String brand;
    private String model;

    // Copy constructor
    public Cars(Cars car) {
        this.brand = car.brand;
        this.model = car.model;
    }

    public Cars(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    @Override
    public Prototype clone() {
        return new Cars(this); //  copy constructor
    }

    @Override
    public String toString() {
        return brand + " " + model;
    }
}


public class PrototypePattern {
    public static void main(String[] args) {
        Cars originalCars = new Cars("Bugatti", "Chiron");
        Cars clonedCars = (Cars) originalCars.clone();

        System.out.println("Original: " + originalCars);
        System.out.println("Cloned: " + clonedCars);
    }
}
