package Serialization_Deserialization;

import java.io.*;

public class Serialization {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.name ="B";
        user.id =2;
        user.display();
        FileOutputStream fileOut = new FileOutputStream("User.ser");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(user);
        out.close();
        fileOut.close();
    }
}
