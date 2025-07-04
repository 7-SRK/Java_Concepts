package DesignPatterns.StructuralDesignPattern;

//It is a structural design pattern that allows two incompatible interfaces to work together.

//The adapter acts as a bridge between the client’s expected interface and the incompatible class.

//The adapter implements the client interface and internally calls the adaptee’s methods, translating calls as needed.

interface H{
    void request();
}

class I{
    public void iRequest(){
        System.out.println("I-Requested Called");
    }
}

class J implements H{
    private I adapter;

    public J(I adapter){
        this.adapter = adapter;
    }
    @Override
    public void request(){
        System.out.println("Request to I-Request");
        adapter.iRequest();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        I adapter = new I();
        H adapter1 = new J(adapter);
        adapter1.request();
    }
}
