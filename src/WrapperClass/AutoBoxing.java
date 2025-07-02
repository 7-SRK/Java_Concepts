package WrapperClass;

import java.util.*;

//AutoBoxing - Automatic Conversion of the primitive types
// to the object of their corresponding wrapper classes

public class AutoBoxing {
    public static void main(String[] args) {
        char ch = 'a';
        Character c = ch;

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(10);
        System.out.println(arr.get(0));
        System.out.println(c);
    }
}
