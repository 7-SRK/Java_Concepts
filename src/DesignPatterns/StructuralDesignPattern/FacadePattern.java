package DesignPatterns.StructuralDesignPattern;

//The Facade Pattern offers a simple, unified interface to a set of interfaces in a complex subsystem.
//
//It decouples clients from the subsystem by hiding the details and exposing only what is necessary.
//
//This helps reduce dependencies, improve code readability, and ease maintenance.
//
//The Facade class acts as a centralized point of access to various subsystem functionalities.

class ServiceA {
    public void operationA() {
        System.out.println("ServiceA: Executing operation A");
    }
}


class ServiceB {
    public void operationB() {
        System.out.println("ServiceB: Executing operation B");
    }
}


class ServiceC {
    public void operationC() {
        System.out.println("ServiceC: Executing operation C");
    }
}

// Facade class that simplifies interaction with subsystems
class Facade {
    private ServiceA serviceA;
    private ServiceB serviceB;
    private ServiceC serviceC;

    public Facade() {
        serviceA = new ServiceA();
        serviceB = new ServiceB();
        serviceC = new ServiceC();
    }

    // Simplified method combining multiple subsystem operations
    public void doComplexOperation() {
        System.out.println("Facade: Starting complex operation...");
        serviceA.operationA();
        serviceB.operationB();
        serviceC.operationC();
        System.out.println("Facade: Complex operation completed.");
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();


        facade.doComplexOperation();
    }
}
