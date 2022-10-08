package Homework11;
import java.util.concurrent.Semaphore;

public class Parent{
    private static final Semaphore SEMAPHORE1 = new Semaphore(1);
    private static final Semaphore SEMAPHORE2 = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        Child child = new Child();
        Thread thread1 = new Thread(child);
        thread1.start();

        for (int i = 0; i < 10; i++) {
            SEMAPHORE1.acquire();
            System.out.println("Hello from parent");
            SEMAPHORE2.release();
        }
    }

    public static class Child implements Runnable{
        @Override
        public void run(){
                for (int i = 0; i < 10; i++) {
                    try {
                        SEMAPHORE2.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Hello from child");
                    SEMAPHORE1.release();
                }

        }
    }
}
