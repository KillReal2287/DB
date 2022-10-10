package homework5;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicReference;


public class Parent {
    public static void main(String[] args) throws Exception {
        AtomicReference<Thread> a = new AtomicReference<>();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (!Thread.interrupted()){
                            System.out.println("Hello world");
                        }
                        System.out.println("Походу всё");
                    }
                });
                thread.start();
                a.set(thread);
            }
        }, 0);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                a.get().interrupt();
                timer.cancel();
            }
        }, 2000);
    }
}