package Homework8;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Homework {
    public static void main(String[] args) {
        ArrayList<Future<Double>> results = new ArrayList<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Походу всё");
            Counter.isInterrupted = true;
            double resulter = 0;
            for (Future<Double> res: results) {
                try{
                    resulter += res.get();
                } catch (InterruptedException e){
                    System.out.println("Something wrong");
                    return;
                } catch (ExecutionException e){
                    System.out.println("Something wrong");
                }
            }
            System.out.println(resulter*4);
            exec.shutdownNow();
        }));
        int threads_count = Integer.parseInt(args[0]);
        CyclicBarrier Barier = new CyclicBarrier(threads_count);
        for (int j = 1; j <= threads_count; j++) {
            results.add(exec.submit(new Counter(j, threads_count,Barier)));
        }
    }
}