package Homework12;

import java.util.LinkedList;
import java.util.List;

public class Child implements Runnable {
    volatile static LinkedList<String> list = new LinkedList<>();
    private final Parent parent;
    Child(Parent parent){
        this.parent = parent;
    }

    public void run() {
        while (true){
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e){
                System.out.println(e);
            }
            bubbleSort(list);
        }
    }

    private void  bubbleSort(List<String> list){
        synchronized (parent) {
            for (int i = 0; i < list.size()-1; i++) {
                for (int j = 0; j < list.size()-1; j++) {
                    if ( list.get(j).compareToIgnoreCase(list.get(j+1)) > 0 ){
                        String tmp = list.get(j);
                        list.set(j, list.get(j+1));
                        list.set(j+1, tmp);
                    }
                }
            }
        }
    }
}
