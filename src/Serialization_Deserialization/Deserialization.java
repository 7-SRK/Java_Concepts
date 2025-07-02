package Serialization_Deserialization;

import java.io.*;

public class Deserialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user =null;
        FileInputStream fileIn = new FileInputStream("C:\\Users\\Admin\\IdeaProjects\\Demo\\User.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        user = (User) in.readObject();
        in.close();
        fileIn.close();

        System.out.println(user.name);
        System.out.println(user.id);
        user.display();
    }
}
