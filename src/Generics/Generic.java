package Generics;

//Generics = A concept where you can write a class, interface, or method
//                     that is compatible with different data types.
//                    <T> type parameter (placeholder that gets replaced with a real type)
//                    <String> type argument (specifies the type)
public class Generic {
    public static void main(String[] args) {

        Box<String> box = new Box<>();
        box.setItems("A");
        System.out.println(box.getItems());

        Product<String, Integer> prod = new Product<>("A",10);
        System.out.println(prod.getItems());
        System.out.println(prod.getPrice());

    }
}