package Java_Parallel_Processing;

import java.util.stream.*;

public class Stream_Support {
    public static void main(String[] args) {
        Iterable<Integer> iterable = () -> IntStream.range(0,100).iterator();

        Stream<Integer> parallelStream = StreamSupport.stream(iterable.spliterator(),true);

        parallelStream.forEach(i->{
            try{
                Thread.sleep(10);
                System.out.println("Processing :" + i + "By" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
