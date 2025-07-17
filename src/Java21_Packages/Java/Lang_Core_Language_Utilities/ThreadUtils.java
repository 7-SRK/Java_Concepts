package Java21_Packages.Java.Lang_Core_Language_Utilities;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ": Count " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " interrupted.");
            }
        }
    }
}


public class ThreadUtils {
    public static void main(String[] args) {
        MyRunnable runnable1 = new MyRunnable();
        Thread thread1 = new Thread(runnable1, "Thread-1"); //

        class MyThread extends Thread {
            public MyThread(String name) {
                super(name);
            }

            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println(Thread.currentThread().getName() + ": Count " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " interrupted.");
                    }
                }
            }
        }
        MyThread thread2 = new MyThread("Thread-2");

        thread1.start();
        thread2.start();
    }
}

