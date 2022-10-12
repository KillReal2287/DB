import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Counter implements Callable<Double> {
    double result;
    private int start;
    private static int step;
    private static CyclicBarrier BARRIER;
    int n; //count of iteration
    static AtomicInteger maximum_iteration = new AtomicInteger(0);
    public volatile static boolean isInterrupted = false;
    Counter(Integer start, Integer step){
        this.start = start;
        Counter.step = step;
        BARRIER = new CyclicBarrier(step);
    }

    @Override
    public Double call() throws BrokenBarrierException, InterruptedException {
        int sign = start % 2 == 0 ? -1 : 1;
        double i = start;
        while (!isInterrupted) {
            sign = step % 2 == 0 ? sign : -sign;
            double number = 1.0/(2.0*i-1);
            result += sign*number;
            i += step;
            n++;
            if (n == Integer.MAX_VALUE){
                maximum_iteration.set(n);
                isInterrupted = true;
                break;
            }
        }


        synchronized (maximum_iteration) {
            if (n>maximum_iteration.get())
                maximum_iteration.set(n);
        }


        BARRIER.await();

        while (n<maximum_iteration.get()){
            sign = step % 2 == 0 ? sign : -sign;
            double number = 1.0/(2*i-1);
            result += sign*number;
            i += step;
            n++;
        }


        return result;
    }
}
