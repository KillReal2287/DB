package Homework10;
public class Child implements Runnable{
    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                this.notify();
                System.out.println("Hello from child");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
