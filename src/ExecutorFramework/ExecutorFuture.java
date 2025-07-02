package ExecutorFramework;

import java.util.concurrent.*;

public class ExecutorFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> callable = ()->"Hello World";
        Future<?> future = executorService.submit(callable);
        System.out.println(future.get());
//        if(future.isDone()){
//            System.out.println("Task is Done! ");
//        }

        executorService.shutdown();

    }
}
