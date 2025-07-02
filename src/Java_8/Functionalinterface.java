package Java_8;

@FunctionalInterface
interface A
{
    void show();
}

//class B implements A
//{
//    public void show()
//    {
//        System.out.println("Show");
//    }
//}

public class Functionalinterface {
    public static void main(String[] args) {
    A obj = new A() {    //Anonymous Inner Class
        public void show() {
            System.out.println("Show Anonymous Inner Class");
        }
    };
    obj.show();
    }
}
