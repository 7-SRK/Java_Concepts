package DesignPatterns.BehavioralDesignPattern;

// Template Method Pattern defines the skeleton of an algorithm in a base class
// and lets subclasses override specific steps.

//To avoid code duplication and enforce a fixed sequence of steps
// while allowing subclasses to customize parts of the algorithm.

abstract class E{
    public final void templateMethod(){
        stepOne();
        stepTwo();
        stepThree();
        stepFour();
        stepFive();
        System.out.println("Algorithm Completed");
    }

    void stepOne(){
        System.out.println("Step 1: Common Initialization For All");
    }

    abstract void stepTwo();
    abstract void stepThree();

    void stepFour(){
        System.out.println("Step 4: Common Process");
    }

    abstract void stepFive();
}

class F extends E{
    @Override
    void stepTwo(){
        System.out.println("Step 2: F's - Step2");
    }

    @Override
    void stepThree() {
        System.out.println("Step 3: F's - Step3");
    }

    @Override
    void stepFive() {
        System.out.println("Step 5: F's - Step5");
    }
}

class G extends E{
    @Override
    void stepTwo(){
        System.out.println("Step 2: G's - Step2");
    }

    @Override
    void stepThree() {
        System.out.println("Step 3: G's - Step3");
    }

    @Override
    void stepFour() {
        System.out.println("Step 4: G's - Step4");
    }

    @Override
    void stepFive() {
        System.out.println("Step 5: G's - Step5");
    }

}

public class TemplatePattern {
    public static void main(String[] args) {

        System.out.println("F's Algorithm : ");
        E obj = new F();
        obj.templateMethod();

        System.out.println();

        System.out.println("G's Algorithm : ");
        E obj1 = new G();
        obj1.templateMethod();

    }
}
