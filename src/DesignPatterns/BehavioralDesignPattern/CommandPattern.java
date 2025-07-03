package DesignPatterns.BehavioralDesignPattern;

//The Command Pattern is a behavioral design pattern that encapsulates a request as an object,
//thereby allowing you to parameterize clients with different requests, queue or log requests,
//and support undoable operations.

interface A{
    void execute();
}

class B{
    void act(){
        System.out.println("Receiver: Action Performed");
    }
}
class C implements A{
    private B receiver;

    public C(B receiver){
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.act();
    }
}

class D{
    private A command;

    public D(A command){
        this.command = command;
    }

    public void invoke(){
        command.execute();
    }
}

public class CommandPattern {
    public static void main(String[] args) {
        B receiver = new B();
        A command = new C(receiver);
        D invoker = new D(command);
        invoker.invoke();
    }
}
