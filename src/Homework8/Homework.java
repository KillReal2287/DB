import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class Homework {
    public static void main(String[] args) {
        ArrayList<Future<Double>> results = new ArrayList<Future<Double>>();
        ExecutorService exec = Executors.newCachedThreadPool();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                System.out.println("Походу всё");
                Counter.isInterrupted = true;
                double resulter = 0;
                for (Future<Double> res: results) {
                    try{
                        resulter += res.get();
                    } catch (InterruptedException e){
                        System.out.println(e);
                        return;
                    } catch (ExecutionException e){
                        System.out.println(e);
                    }
                }
                System.out.println(resulter*4);
                exec.shutdownNow();
            }
        });
        Integer threads_count = Integer.parseInt(args[0]);
        for (int j = 1; j <= threads_count; j++) {
            results.add(exec.submit(new Counter(j, threads_count)));
        }
    }
}
