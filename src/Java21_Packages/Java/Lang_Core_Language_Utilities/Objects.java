package Java21_Packages.Java.Lang_Core_Language_Utilities;

public class Objects extends Object{
    private String name;

    public Objects(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Objects with name: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Objects myObject = (Objects) obj;
        return name.equals(myObject.name);
    }


    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public static void main(String[] args) {
        Objects obj1 = new Objects("ABDC");
        Objects obj2 = new Objects("B");
        Objects obj3 = new Objects("ABDC");


        System.out.println("obj1.toString(): " + obj1.toString());


        System.out.println("obj1.equals(obj2): " + obj1.equals(obj2));
        System.out.println("obj1.equals(obj3): " + obj1.equals(obj3));


        System.out.println("obj1.hashCode(): " + obj1.hashCode());
        System.out.println("obj2.hashCode(): " + obj2.hashCode());


        System.out.println("obj1.getClass().getName(): " + obj1.getClass().getName());
    }
}
