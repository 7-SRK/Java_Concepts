package Java21_Packages.Java.Util.Concurrent;

import java.util.concurrent.*;

public class Executor_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(2);
        Future<Integer> res = exe.submit(()-> 7*6);
        System.out.println(res.get());
        exe.shutdown();

        //ConcurrentMap
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        map.put("A", 1);
        System.out.println(map.get("A"));

        //CountDownLatch
        CountDownLatch latch = new CountDownLatch(1);
        new Thread(() -> {
            System.out.println("Done in thread");
            latch.countDown();
        }).start();
        latch.await();
        System.out.println("Main thread continues");

        //Semaphore
        Semaphore sem = new Semaphore(1);
        sem.acquire();
        try {
            System.out.println("Only one at a time!");
        } finally {
            sem.release();
        }

        //Virtual Thread
        Thread vt = Thread.ofVirtual().start(() -> {
            System.out.println("Virtual thread: " + Thread.currentThread());
        });

        vt.join();

        Thread.Builder builder = Thread.ofVirtual().name("VirtualThread-", 1);
        Runnable task = () -> System.out.println("Running in " + Thread.currentThread().getName());

        Thread t1 = builder.start(task);
        Thread t2 = builder.start(task);

        t1.join();
        t2.join();
    }
}
