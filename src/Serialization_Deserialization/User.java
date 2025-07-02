package Serialization_Deserialization;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    int id;

    public void display(){
        System.out.println(id+ " : " +name);
    }
}
