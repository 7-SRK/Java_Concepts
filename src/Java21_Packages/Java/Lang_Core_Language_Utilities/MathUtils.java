package Java21_Packages.Java.Lang_Core_Language_Utilities;

public class MathUtils {
    public static void main(String[] args) {
        double x = 25.0;
        double y = 5.0;

        System.out.println("Square root of " + x + ": " + Math.sqrt(x)); //

        System.out.println(x + " Power of " + y + ": " + Math.pow(x, y)); //

        System.out.println("Absolute value of -10: " + Math.abs(-10));

        System.out.println("Ceiling of 5.1: " + Math.ceil(5.1));
        System.out.println("Floor of 4.7: " + Math.floor(4.7));

        System.out.println("Round 4.3: " + Math.round(4.3));
        System.out.println("Round 4.7: " + Math.round(4.7));

        System.out.println("Random number (0.0 to 1.0): " + Math.random());
    }

}
