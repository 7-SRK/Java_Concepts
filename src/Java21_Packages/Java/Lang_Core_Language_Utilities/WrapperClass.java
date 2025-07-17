package Java21_Packages.Java.Lang_Core_Language_Utilities;

public class WrapperClass {
    public static void main(String[] args) {
        int primitiveInt = 100;

        Integer wrapperInt = primitiveInt;
        System.out.println("Wrapper Integer: " + wrapperInt);

        int anotherPrimitiveInt = wrapperInt;
        System.out.println("Unboxed int: " + anotherPrimitiveInt);

        Integer i1 = Integer.valueOf(50);
        Integer i2 = Integer.valueOf("250");
        System.out.println("i1: " + i1 + ", i2: " + i2);

        String str = "123";
        int parsedInt = Integer.parseInt(str); //
        System.out.println("Parsed int from string: " + parsedInt);

        Integer num1 = Integer.valueOf(10);
        Integer num2 = Integer.valueOf(10);
        System.out.println("num1 == num2 : " + (num1 == num2));
        System.out.println("num1.equals(num2): " + num1.equals(num2));
    }
}
