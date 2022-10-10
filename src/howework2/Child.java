package howework2;
class Child implements Runnable {
    private Thread thr;

    public Child() {
        thr = new Thread(this, "Thread1");
        thr.start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello world from child");
        }
    }
    public Thread getThread() {
        return thr;
    }
}
