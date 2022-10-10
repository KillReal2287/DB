package howework1;
class Child implements Runnable{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello world from child)");
        }
        Thread.yield();
    }
}
