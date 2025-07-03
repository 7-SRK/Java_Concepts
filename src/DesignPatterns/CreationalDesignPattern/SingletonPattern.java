package DesignPatterns.CreationalDesignPattern;

//It restricts the instantiation of a class to a single object.

//Provides a global access point to that instance.

//Useful for resources that are expensive or logically should have only one instance,
// such as database connections or configuration managers.

// The volatile keyword in Java is used to indicate that a variable's value will be modified by different threads.
// It ensures that changes to a variable are always visible to other threads, preventing thread caching issues.

class Singleton {
    private static volatile Singleton instance;
    private String data;

    private Singleton() {
        data = "Singleton Data";
    }

    public static Singleton getInstance() {
        Singleton localInstance = instance;
        if (localInstance == null) {
            synchronized (Singleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Singleton();
                }
            }
        }
        return localInstance;
    }

    public String getData() {
        return data;
    }
}



public class SingletonPattern {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1.getData());
        System.out.println(singleton1 == singleton2);
    }

}

