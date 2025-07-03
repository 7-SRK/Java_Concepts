package DesignPatterns.StructuralDesignPattern;

//The Proxy Pattern acts as an intermediary between the client and the real object.

//It provides a substitute or placeholder for another object.

//The proxy controls access to the original object, allowing you to perform actions before or after forwarding the request.

//It implements the same interface as the original object so it can be used interchangeably.

interface E{
    void request();
}

// The Actual Object that does the work
class F implements E{
    @Override
    public void request() {
        System.out.println("F: Executing Request");
    }
}

//Proxy class that controls access to F
class G implements E{
    private F f;

    public G(){
        this.f = new F();
    }
    @Override
    public void request(){
        System.out.println("Before request");
        f.request();
        System.out.println("After request");
    }
}

public class ProxyPattern {
    public static void main(String[] args) {
        E proxy = new G();
        proxy.request();
    }
}
