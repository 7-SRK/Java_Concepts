package DesignPatterns.BehavioralDesignPattern;

//The State Pattern is a behavioral design pattern that allows an object
// to change its behavior when its internal state changes.
// The object appears to change its class dynamically.

interface H {
    void pressHomeButton();
    void pressPowerButton();
}

// Class that changes behavior based on state
class I {
    private H currentState;

    public I() {
        // Initial state is OffState
        this.currentState = new OffState(this);
    }

    public void setState(H state) {
        this.currentState = state;
    }

    public void pressHomeButton() {
        currentState.pressHomeButton();
    }

    public void pressPowerButton() {
        currentState.pressPowerButton();
    }
}

// Concrete State: Off State
class OffState implements H {
    private I phone;

    public OffState(I phone) {
        this.phone = phone;
    }

    @Override
    public void pressHomeButton() {
        System.out.println("Phone is OFF. Turning ON and locking...");
        phone.setState(new LockedState(phone));
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Phone is OFF. Turning ON and locking...");
        phone.setState(new LockedState(phone));
    }
}

// Concrete State: Locked State
class LockedState implements H {
    private I phone;

    public LockedState(I phone) {
        this.phone = phone;
    }

    @Override
    public void pressHomeButton() {
        System.out.println("Phone is locked. Unlocking...");
        phone.setState(new ReadyState(phone));
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Phone is locked. Turning OFF...");
        phone.setState(new OffState(phone));
    }
}

// Concrete State: Ready State (unlocked)
class ReadyState implements H {
    private I phone;

    public ReadyState(I phone) {
        this.phone = phone;
    }

    @Override
    public void pressHomeButton() {
        System.out.println("Phone is unlocked. Going to home screen...");
    }

    @Override
    public void pressPowerButton() {
        System.out.println("Phone is unlocked. Locking phone...");
        phone.setState(new LockedState(phone));
    }
}


public class StatePattern {
    public static void main(String[] args) {
        I phone = new I();  // Phone initially OFF

        phone.pressPowerButton();
        phone.pressHomeButton();
        phone.pressHomeButton();
        phone.pressPowerButton();
        phone.pressPowerButton();
    }
}


 