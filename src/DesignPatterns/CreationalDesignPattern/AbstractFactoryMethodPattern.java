package DesignPatterns.CreationalDesignPattern;

//It is a creational design pattern that lets you produce families of related objects
// without specifying their concrete classes.

//Think of it as a factory of factories: instead of a single factory creating one product type,
// the abstract factory creates multiple related products.

//It extends the Factory Method pattern by handling multiple product types that belong to a family.


interface Gpu {
    void assemble();
}

interface Monitor {
    void assemble();
}

class MsiGpu implements Gpu {
    public void assemble() {
        System.out.println("Assembling MSI GPU");
    }
}

class AsusGpu implements Gpu {
    public void assemble() {
        System.out.println("Assembling ASUS GPU");
    }
}

class MsiMonitor implements Monitor {
    public void assemble() {
        System.out.println("Assembling MSI Monitor");
    }
}

class AsusMonitor implements Monitor {
    public void assemble() {
        System.out.println("Assembling ASUS Monitor");
    }
}

interface ComputerFactory {
    Gpu createGpu();
    Monitor createMonitor();
}

class MsiFactory implements ComputerFactory {
    public Gpu createGpu() {
        return new MsiGpu();
    }
    public Monitor createMonitor() {
        return new MsiMonitor();
    }
}

class AsusFactory implements ComputerFactory {
    public Gpu createGpu() {
        return new AsusGpu();
    }
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}



public class AbstractFactoryMethodPattern {
    public static void main(String[] args) {
        ComputerFactory factory = new MsiFactory();

        Gpu gpu = factory.createGpu();
        Monitor monitor = factory.createMonitor();

        gpu.assemble();
        monitor.assemble();

        System.out.println();

        factory = new AsusFactory();

        gpu = factory.createGpu();
        monitor = factory.createMonitor();

        gpu.assemble();
        monitor.assemble();
    }
}
