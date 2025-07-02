package Polymorphism;

public class MethodOverloading {
    void display(){
        System.out.println("No Input");
    }

    void display(int id){
        System.out.println("Id : "+ id);
    }

    void display(String name, int salary){
        System.out.println("Name : "+ name + " Salary : " + salary);
    }

    public static void main(String[] args) {
        MethodOverloading over = new MethodOverloading();
        over.display();
        over.display(1);
        over.display("Ram",100000);
    }
}
