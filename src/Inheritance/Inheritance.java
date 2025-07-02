package Inheritance;

public class Inheritance {
    public static void main(String[] args) {
        Car car = new Car();
        car.go();

        Bike bike = new Bike();
        bike.stop();
        System.out.println();

        System.out.println(car.doors);
        System.out.println(car.wheels);
        System.out.println();

        System.out.println(bike.doors);
        System.out.println(bike.wheels);

    }
}
