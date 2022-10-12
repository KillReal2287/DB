package Homework6;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Worker implements Runnable{
    private Department department;
    private CyclicBarrier cyclicBarrier;

    public Worker(Department department, CyclicBarrier cyclicBarrier){
        this.department = department;
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        department.performCalculations();
        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
