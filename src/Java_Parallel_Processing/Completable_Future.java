package Java_Parallel_Processing;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Completable_Future {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        CompletableFuture<Void> comp = CompletableFuture.runAsync(()->{
            try{
                Thread.sleep(10);
                System.out.println("Task Done By : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },executor);

        comp.join();
        executor.shutdown();
    }
}
