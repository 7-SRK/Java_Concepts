package ExecutorFramework;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ExecutorFramework {
    public static void main(String[] args)  {
        //long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 1; i < 10; i++) {
            int finalI = i;
            //executor.execute(
            Future<?> future = executor.submit(() -> {
                        long result = factorial(finalI);
                        System.out.println(result);
                    });
        }
        executor.shutdown();
//        try {
//            while(!executor.awaitTermination(10,TimeUnit.MILLISECONDS)){
//                System.out.println("Waiting...");
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        for (Thread thread :threads){
//           try {
//                thread.join();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
        //System.out.println("Total Time: " + (System.currentTimeMillis() - startTime ));
    }

    private static long factorial(int n)  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long result = 1;
        for (int i = 1; i <=n; i++) {
            result *= i;
        }
         return result;
    }
}
