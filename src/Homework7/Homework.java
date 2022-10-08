package Homework7;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Homework {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Double>> results = new ArrayList<Future<Double>>();
        double result = 0;
        Integer threads_count = Integer.parseInt(args[0]);
        Integer iteration_count = 100000;
        Integer repeats = iteration_count/threads_count; //по сколько итераций будет в каждом потоке
        Integer begin = 1;
        Integer end;
        Integer rest = iteration_count % threads_count;
        for (int i = 1; i <= threads_count; i++) {
            if (rest > 0){
                end = i * repeats + 1;
                rest--;
            }
            else{
                end = i * repeats;
            }
            results.add(exec.submit(new Counter(begin, end)));
            begin = end;
        }

        for (Future<Double> resulter: results) {
            try{
                result += resulter.get();
            } catch (InterruptedException e){
                System.out.println(e);
                return;
            } catch (ExecutionException e){
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
        }
        System.out.println(result*4);
    }
}
