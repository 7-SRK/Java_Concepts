package Java_Parallel_Processing;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoin extends RecursiveTask<Integer> {
    private final int[] data;
    private final int start, end;
    private static final int THRESOLD = 10;

    public ForkJoin(int[] data, int start, int end){
        this.data = data;
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        if(end - start <= THRESOLD) {
            int sum = 0;
            for (int i = start; i < end; i++)
                sum += data[i];
            return sum;
        }
        else{
                int mid = (start + end)/2;
                ForkJoin left = new ForkJoin(data, start, mid);
                ForkJoin right = new ForkJoin(data, mid, end);

                left.fork();
                int rightRes = right.compute();
                int leftRes = left.join();

                return leftRes + rightRes;
            }
        }

    public static void main(String[] args) {
        int[] data = new int[100];
        for (int i = 0; i < data.length; i++)
            data[i] = i+1;

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoin task = new ForkJoin(data,0, data.length);

        int result = pool.invoke(task);
        System.out.println("Sum : " + result);
    }

    }

