package by.it.karmyzov.Test.MultiThreadimg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SumNumbers {
    private static long value = 1_000_000_000L;
    private static long sum = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Long>> futureResults = new ArrayList<>();
        Long valueDividevBy10 = value / 10;
        for (int i = 0; i < 10; i++) {
            long from = valueDividevBy10 * i + 1;
            long to = valueDividevBy10 * (i + 1);
            PartialSum task = new PartialSum(from, to);
            Future<Long> futurePartsum = executorService.submit(task);
            futureResults.add(futurePartsum);
        }
        for (Future<Long>result :futureResults) {
            sum+= result.get();


        }
        executorService.shutdown();
        System.out.println("total sum = " + sum);
    }
}

class PartialSum implements Callable<Long> {
    long from;
    long to;
    long localSuml;

    public PartialSum(long from, long to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Long call() {
        for (long i = from; i <= to; i++) {
            localSuml += i;
        }
        System.out.println("Sum from " + from + "to" + to + "=" + localSuml);
        return localSuml;
    }
}
