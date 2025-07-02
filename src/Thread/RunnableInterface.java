package Thread;

//Runnable interface being a functional interface has its own run() method.
// Here classes are implemented to the Runnable interface.
// Later on, in the main() method, Runnable reference is created for the classes that are implemented in order to make bondage with Thread class to run our own corresponding run() methods.

class ThreadRun1 implements Runnable{

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread1");
            try{
                //sleep Making the thread pause for a certain
                // time using sleep() method

                Thread.sleep(1000);
            }
            catch (Exception e) {
            }
        }
    }
}

class ThreadRun2 implements Runnable{

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread2");
            try{
                Thread.sleep(1000);
            }
            catch (Exception e) {
            }
        }
    }
    }


public class RunnableInterface {
    public static void main(String[] args) {

        // Creating reference of Runnable to
        // our classes above in main() method

        Runnable obj1 = new ThreadRun1();
        Runnable obj2 = new ThreadRun2();

        // Creating reference of thread class by passing
        // object of Runnable in constructor of Thread class

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
    }
}
