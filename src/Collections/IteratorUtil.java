package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorUtil {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 2 != 0) {
                iterator.remove();
            }
        }
        System.out.println("Even numbers: " + numbers);
    }
}
