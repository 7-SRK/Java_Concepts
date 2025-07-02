package DesignPatterns.CreationalDesignPattern;

//The Factory Method is a creational design pattern that provides an interface for creating objects in a superclass
//but allows subclasses to alter the type of objects that will be created. Instead of calling a constructor directly to create an object,
//the client calls a factory method that returns an instance of a product class.

abstract class Burger{
    abstract void prepare();
}

class ChickenBurger extends Burger {
    @Override
    void prepare(){
        System.out.println("Preparing Chicken Burger");
    }
}

class VeggieBurger extends Burger {
    @Override
    void prepare(){
        System.out.println("Preparing Veggie Burger");
    }
}

abstract class Restaurant{
    public Burger orderBurger() {
        Burger burger = createBurger();
        burger.prepare();
        return burger;
    }
    public abstract Burger createBurger();
    }

class ChickenBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger(){
        return new ChickenBurger();
    }

}

class VeggieBurgerRestaurant extends Restaurant {
    @Override
    public Burger createBurger(){
        return new VeggieBurger();
    }

}


public class FactoryMethodPattern {
    public static void main(String[] args) {
        Restaurant restaurant = new ChickenBurgerRestaurant();
        Burger burger1 = restaurant.orderBurger();
        System.out.println();

        restaurant = new VeggieBurgerRestaurant();
        Burger burger2 = restaurant.orderBurger();
    }
}
