package DesignPatterns.CreationalDesignPattern;

//The Builder Pattern separates the construction of a complex object from its representation,
// so the same construction process can create different representations.
//
//It is especially useful when an object has many fields, some optional, and
// when constructors with many parameters become unwieldy or unclear.
//
//Instead of using numerous constructors or setters scattered across client code,
// the Builder Pattern encapsulates the construction logic inside a builder class.
//
//Optionally, a Director class can be used to define the order of construction steps and reuse common building routines.


class Car {
    private String brand;
    private String model;
    private String color;
    private int doors;

    // Private constructor accessed only by Builder i.e. to prevent direct instantiation of Car objects from outside the class.
    //Car objects are created through the CarBuilder, ensuring immutability and controlled construction.
    private Car(CarBuilder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.color = builder.color;
        this.doors = builder.doors;
    }

    @Override
    public String toString() {
        return brand + " " + model + ", Color: " + color + ", Doors: " + doors;
    }

    // Builder class
    public static class CarBuilder {
        private String brand;
        private String model;
        private String color;
        private int doors;

        public CarBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder model(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder doors(int doors) {
            this.doors = doors;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder()
                .brand("Bugatti")
                .model("Chiron")
                .color("Blue")
                .doors(2)
                .build();

        System.out.println(car);
    }
}
