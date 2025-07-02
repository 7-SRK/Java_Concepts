package Polymorphism;

class Car extends Vehicle {
    int wheels = 4;
    int doors= 0;

    @Override
    void go(){
        System.out.println("Car is Moving");
    }

}
