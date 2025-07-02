package Inheritance;

class Transmission extends Car{
    String transmission1 = "Manual";
    String transmission2 = "Automatic";
}

public class MultiLevel {
    public static void main(String[] args) {
        Transmission transmission = new Transmission();
        System.out.println("Car is " + transmission.transmission1 +" transmission with " +transmission.doors+" Doors and " + transmission.wheels +" Wheels " + " and currently at");
        transmission.stop();
    }
}
