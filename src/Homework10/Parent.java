package Homework10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Parent{
    public static boolean queue;

    public static void main(String[] args) throws InterruptedException {
        Child child = new Child();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(child);
        executor.shutdown();
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello from parent ");
                synchronized (child) {
                    Parent.queue = true;
                    child.notifyAll();
                    if (i != 9)
                    while (Parent.queue) {
                        child.wait();
                    }
                }
        }
    }
}
