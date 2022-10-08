package Homework10;

public class Parent{
    public static void main(String[] args) throws InterruptedException {
        Child child = new Child();
        Thread thread1 = new Thread(child);
        thread1.start();
        synchronized (child){
            for (int i = 0; i < 10; i++) {
                child.notify();
                System.out.println("Hello from parent");
                child.wait();
            }
            child.notify();
        }
    }
}
