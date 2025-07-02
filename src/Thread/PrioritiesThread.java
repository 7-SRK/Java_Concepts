package Thread;

//Priorities in threads is a concept where each thread is having a priority which is represented by numbers ranging from 1 to 10.
//
//The default priority is set to 5 as excepted.
//Minimum priority is set to 1.
//Maximum priority is set to 10.
//Here 3 constants are defined in it namely as follows:
//
//public static int NORM_PRIORITY
//public static int MIN_PRIORITY
//public static int MAX_PRIORITY

class Threadnopriority extends Thread {

    public void run()
    {

        // Printing the current running thread via getName()
        // method using currentThread() method
        System.out.println("Running Thread : "
                + currentThread().getName());

        // Print and display the priority of current thread
        // via currentThread() using getPriority() method
        System.out.println("Running Thread Priority : "
                + currentThread().getPriority());
    }
}

public class PrioritiesThread {
    public static void main(String[] args)
    {

        // Creating objects of MyThread(above class)
        // in the main() method
        Threadnopriority t1 = new Threadnopriority();
        Threadnopriority t2 = new Threadnopriority();
        Threadnopriority t3 = new Threadnopriority();
        Threadnopriority t4 = new Threadnopriority();

        // t1: Default Priority no setting
        // t2: NORM Priority no setting
        // t3: MIN Priority no setting
        // t4: MAX Priority no setting

        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t4.setPriority(Thread.MAX_PRIORITY);


        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
