package DesignPatterns.BehavioralDesignPattern;

//The Strategy Pattern is a behavioral design pattern that defines a family of algorithms,
// encapsulates each one in a separate class, and makes them interchangeable.
// It lets the algorithm vary independently from clients that use it, promoting flexibility and adherence to the Open/Closed Principle.

interface K {
    void pay(int amount);
}

// Concrete Strategy 1: Credit Card Payment
class L implements K {
    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Credit Card.");
    }
}

// Concrete Strategy 2: GPay Payment
class M implements K {
    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using GPay.");
    }
}


class N {
    private K paymentStrategy;

    public N(K paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void setPaymentStrategy(K paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void payAmount(int amount) {
        paymentStrategy.pay(amount);
    }
}


public class StrategyPattern {
    public static void main(String[] args) {
        N paymentService = new N(new L()); // Use Credit Card strategy
        paymentService.payAmount(100);

        // Switch to GPay strategy at runtime
        paymentService.setPaymentStrategy(new M());
        paymentService.payAmount(200);
    }
}
