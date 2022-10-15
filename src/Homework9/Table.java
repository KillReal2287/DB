package Homework9;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Table {
    public static void main(String[] args) {
        ArrayList<Philosopher> philosophers = new ArrayList<>();
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Fork> forks = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            forks.add(new Fork(i));
        }
        for (int i=0; i<5; i++){
            exec.execute(new Philosopher(i, forks));
        }
        exec.shutdown();
    }
}
