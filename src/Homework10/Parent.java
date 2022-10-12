package Homework10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parent{
    public volatile static boolean queue;
    public static void main(String[] args) throws InterruptedException {
        Child child = new Child();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Thread.sleep(10000);
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello from parent ");
                    synchronized (child) {
                        Parent.queue = true;
                        if (i == 0){
                            executor.execute(child);
                        }
                        child.notifyAll();
                        if (i != 9)
                        while (Parent.queue) {
                            child.wait();
                        }
                    }
            }
        executor.shutdown();
    }
}
