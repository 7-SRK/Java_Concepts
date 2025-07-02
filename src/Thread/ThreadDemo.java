package Thread;

// run() method which is called as soon as thread is started
// start() method will look for run() and execute it
// show() no start() method is executed so here only thread is created only followed by call

class Thread1 extends Thread{
    public void run(){
        System.out.println("Thread1 is running");
    }
}

class Thread2 extends Thread{
    public void run(){
        System.out.println("Thread2 is running");
    }
}

class Thread3 extends Thread{
    public void show(){
        System.out.println("Thread3");
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Thread1 obj1 = new Thread1();
        Thread2 obj2 = new Thread2();
        Thread3 obj3 = new Thread3();
        obj1.start();
        obj2.start();
        obj3.show();
    }


}
