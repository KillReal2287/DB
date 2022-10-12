package Homework10;


public class Child implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i<10; i++) {
            System.out.println("Hello from child ");
            synchronized (this){
                Parent.queue = false;
                this.notifyAll();
                if(i != 9) {
                    while (!Parent.queue) {
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
}
