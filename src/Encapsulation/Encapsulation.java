package Encapsulation;

//Encapsulation
//It is defined as the wrapping up of data under a single unit.
// It is the mechanism that binds together the code and the data it manipulates.
// Another way to think about encapsulation is that it is a protective shield that prevents the data from being accessed by the code outside this shield.



class Encap{
    private int age;
    private String name;

    public int getAge(){
        return age;
    }

    public void setAge(int a){

        age = a;
    }
                  
    public String getName(){
        return name;
    }

    public void setName(String n) {
        name = n;
    }
}

public class Encapsulation {
    public static void main(String[] args) {

        Encap obj = new Encap();
        obj.setAge(21);
        obj.setName("Ram");
        System.out.println(obj.getName() + " : " + obj.getAge());
    }
}


