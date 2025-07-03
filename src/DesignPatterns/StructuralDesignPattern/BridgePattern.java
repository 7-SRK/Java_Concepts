package DesignPatterns.StructuralDesignPattern;

//Bridge is a structural design pattern that divides business logic or huge class
//into separate class hierarchies that can be developed independently.

interface Restaurant {
    void preparePizza(String pizzaType);
}

class AmericanRestaurant implements Restaurant {
    public void preparePizza(String pizzaType) {
        System.out.println("Preparing " + pizzaType + " in American style.");
    }
}

class ItalianRestaurant implements Restaurant {
    public void preparePizza(String pizzaType) {
        System.out.println("Preparing " + pizzaType + " in Italian style.");
    }
}


abstract class Pizza {
    protected Restaurant restaurant;  // Bridge to implementation

    public Pizza(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    abstract void deliver();
}

class PepperoniPizza extends Pizza {
    public PepperoniPizza(Restaurant restaurant) {
        super(restaurant);
    }

    public void deliver() {
        restaurant.preparePizza("Pepperoni Pizza");
        System.out.println("Delivering Pepperoni Pizza.");
    }
}

class VeggiePizza extends Pizza {
    public VeggiePizza(Restaurant restaurant) {
        super(restaurant);
    }

    public void deliver() {
        restaurant.preparePizza("Veggie Pizza");
        System.out.println("Delivering Veggie Pizza.");
    }
}


public class BridgePattern {
    public static void main(String[] args) {
        Restaurant american = new AmericanRestaurant();
        Restaurant italian = new ItalianRestaurant();

        Pizza pizza1 = new PepperoniPizza(american);
        pizza1.deliver();

        System.out.println();

        Pizza pizza2 = new VeggiePizza(italian);
        pizza2.deliver();

    }
}


