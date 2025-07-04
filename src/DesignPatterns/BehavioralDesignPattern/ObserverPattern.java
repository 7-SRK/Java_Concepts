package DesignPatterns.BehavioralDesignPattern;

import java.util.*;

//The Observer Pattern is a behavioral design pattern that defines a one-to-many dependency
// between objects so that when one object (the Subject) changes its state,
// all its dependents (called Observers) are notified and updated automatically.


// Observer interface
interface O {
    void update(String message);
}

// Subject interface
interface P {
    void subscribe(O observer);
    void unsubscribe(O observer);
    void notifyObservers(String message);
}

// Concrete Subject (Publisher)
class R implements P {
    private List<O> observers = new ArrayList<>();

    @Override
    public void subscribe(O observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(O observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (O observer : observers) {
            observer.update(message);
        }
    }

    // Business logic that triggers notification
    public void newProductArrived(String product) {
        System.out.println("Store: New product arrived - " + product);
        notifyObservers("New product available: " + product);
        System.out.println();
    }
}

// Concrete Observer 1: Email Notification
class S implements O {
    private String email;

    public S(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Email to " + email + ": " + message);
        System.out.println();
    }
}

// Concrete Observer 2: Mobile App Notification
class T implements O {
    private String username;

    public T(String username) {
        this.username = username;
    }

    @Override
    public void update(String message) {
        System.out.println("Push notification to " + username + ": " + message);
        System.out.println();
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        R store = new R();

        O emailSubscriber = new S("customer@example.com");
        O mobileSubscriber = new T("user123");

        store.subscribe(emailSubscriber);
        store.subscribe(mobileSubscriber);

        store.newProductArrived("Phone");
        store.newProductArrived("Laptop");

        store.unsubscribe(emailSubscriber);

        store.newProductArrived("Tablet");
    }
}
