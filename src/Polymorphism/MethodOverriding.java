package Polymorphism;
//Polymorphism.MethodOverriding
// Declaring a method in subclass, which is already present
// in the parent class. it is done so that a child class
// can give its own implementation


public class MethodOverriding {

    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle();
        vehicle.go();
        System.out.println();
        Car car = new Car();
        car.go();

    }
}
