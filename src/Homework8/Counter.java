package Homework8;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicLong;

public class Counter implements Callable<Double> {
    double result;
    private final long  start;
    private final long step;
    private final CyclicBarrier Barrier;
    long n = Long.MIN_VALUE; //count of iteration
    static final AtomicLong maximum_iteration = new AtomicLong(Long.MIN_VALUE);
    public volatile static boolean isInterrupted = false;
    Counter(Integer start, Integer step, CyclicBarrier Barrier){
        this.start = start;
        this.step = step;
        this.Barrier = Barrier;
    }

    @Override
    public Double call() throws BrokenBarrierException, InterruptedException {
        long sign = start % 2 == 0 ? -1 : 1;
        double i = start;
        while (!isInterrupted) {
            sign = step % 2 == 0 ? sign : -sign;
            double number = 1.0/(2.0*i-1);
            result += sign*number;
            i += step;
            n++;
            if (n == Long.MAX_VALUE){
                maximum_iteration.set(n);
                isInterrupted = true;
                break;
            }
        }


        synchronized (maximum_iteration) {
            if (n>maximum_iteration.get())
                maximum_iteration.set(n);
        }

        Barrier.await();

        while (n<maximum_iteration.get()){
            sign = step % 2 == 0 ? sign : -sign;
            double number = 1.0/(2*i-1);
            result += sign*number;
            i += step;
            n++;
        }

        if (step%2 == 1){
            return -result;
        }

        return result;
    }
}