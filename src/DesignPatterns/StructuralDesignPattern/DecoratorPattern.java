package DesignPatterns.StructuralDesignPattern;

// Decorator Pattern as a structural design pattern that allows you to dynamically add
// new responsibilities or behaviors to objects without modifying their original code.
// This is achieved by wrapping the original object inside decorator classes that implement
// the same interface, effectively "decorating" the object with additional features.

interface A {
    void doSomething();
}

// Concrete Component
class ConcreteA implements A {
    @Override
    public void doSomething() {
        System.out.println("ConcreteA: Doing something");
    }
}

// Decorator Abstract Class
abstract class DecoratorA implements A {
    protected A wrapped;

    public DecoratorA(A wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void doSomething() {
        wrapped.doSomething();  // delegate call
    }
}

// Concrete Decorator adding extra behavior
class ConcreteDecoratorA extends DecoratorA {

    public ConcreteDecoratorA(A wrapped) {
        super(wrapped);
    }

    @Override
    public void doSomething() {
        super.doSomething();  // call original behavior
        addedBehavior();     // add extra behavior
    }

    private void addedBehavior() {
        System.out.println("ConcreteDecoratorA: Adding extra behavior");
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        A original = new ConcreteA();
        System.out.println("Original object:");
        original.doSomething();

        System.out.println("\nDecorated object:");
        A decorated = new ConcreteDecoratorA(original);
        decorated.doSomething();
    }
}
