package DesignPatterns.StructuralDesignPattern;

//The Facade Pattern offers a simple, unified interface to a set of interfaces in a complex subsystem.
//
//It decouples clients from the subsystem by hiding the details and exposing only what is necessary.
//
//This helps reduce dependencies, improve code readability, and ease maintenance.
//
//The Facade class acts as a centralized point of access to various subsystem functionalities.

class B {
    public void operationB() {
        System.out.println("B: Executing operation B");
    }
}


class C {
    public void operationC() {
        System.out.println("C: Executing operation C");
    }
}


class D {
    public void operationD() {
        System.out.println("D: Executing operation D");
    }
}

// Facade class that simplifies interaction with subsystems
class Facade {
    private B serviceB;
    private C serviceC;
    private D serviceD;

    public Facade() {
        serviceB = new B();
        serviceC = new C();
        serviceD = new D();
    }


    public void doOperation() {
        System.out.println("Facade: Starting complex operation...");
        serviceB.operationB();
        serviceC.operationC();
        serviceD.operationD();
        System.out.println("Facade: Complex operation completed.");
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();


        facade.doOperation();
    }
}
