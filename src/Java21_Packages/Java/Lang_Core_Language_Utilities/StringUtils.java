package Java21_Packages.Java.Lang_Core_Language_Utilities;

public class StringUtils {
    public static void main(String[] args) {
        String str = "Hello, World!";
        String name = "Java";
        
        String message = str + " " + name;
        System.out.println("Concatenated string: " + message);

        System.out.println("Length of str: " + str.length());

        System.out.println("Character at index 7: " + str.charAt(7));

        System.out.println("Substring from index 7: " + str.substring(7));
        System.out.println("Substring from index 0 to 5: " + str.substring(0, 5));

        System.out.println("str.equals(\"Hello, World!\"): " + str.equals("Hello, World!"));
        System.out.println("str.equalsIgnoreCase(\"hello, World!\"): " + str.equalsIgnoreCase("hello, World!"));

        System.out.println("Index of 'World': " + str.indexOf("World"));

        System.out.println("Replace 'World' with 'Java': " + str.replace("World", "Java"));

        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());

        String paddedString = "  Hello World   ";
        System.out.println("Trimmed string: " + paddedString.trim());
    }
}
