package Homework12;

public class Child implements Runnable {
    List list;
    
    public Child(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                System.out.println(e);
            }
            list.sorter();
        }
    }
}
