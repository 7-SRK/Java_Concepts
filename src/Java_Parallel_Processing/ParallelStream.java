package Java_Parallel_Processing;

import java.util.stream.IntStream;

public class ParallelStream {
    public static void main(String[] args) {
        IntStream.range(0,100)
                .parallel()
                .forEach(i->{
                    try{
                        Thread.sleep(10);
                        System.out.println("Processing: " + i + "by" + Thread.currentThread().getName());
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                });
    }
}
