package Java_Parallel_Processing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//ExecutorService:
//ExecutorService manages a pool of threads and lets you submit tasks for asynchronous execution.
// It handles thread creation, scheduling, and lifecycle for you.

public class Executor_Service {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0 ; i<20; i++){
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                try{
                    Thread.sleep(10);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }, executorService);
            futures.add(future);
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();
        System.out.println("Tasks Completed");

        }
    }

