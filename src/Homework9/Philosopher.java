package Homework9;

import java.util.ArrayList;

public class Philosopher implements Runnable {
    final int id;
    final Fork  right;
    final Fork left;
    public void  eat() throws InterruptedException {
        while (true) {
            System.out.println(" is thinking about life ");
            synchronized (left){
                synchronized (right){
                    System.out.println(" is eating with right " + right + " fork left " + left + " fork");
                }
            }
        }
    }

    Philosopher(int id, ArrayList<Fork> forks){
        this.id = id;
        this.left = forks.get(id);
        this.right = forks.get((id +1) % 5);
    }

    @Override
    public void run() {
        System.out.println(this);
        try {
            eat();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return " sat at the table with id " + id + " and his left fork is " + this.left
         + " and his right fork is " + this.right;
    }
}
