package Homework6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public final class Founder {
    private final List<Runnable> workers;
     static Company company;
     static int workers_count;
     private static CyclicBarrier BARRIER;

    public Founder(final Company company) {
        Founder.company = company;
        this.workers = new ArrayList<>(company.getDepartmentsCount());
        workers_count = company.getDepartmentsCount();
        BARRIER = new CyclicBarrier(workers_count, new Runnable() {
            @Override
            public void run() {
                company.showCollaborativeResult();
            }
        });
        for (int i = 0; i < company.getDepartmentsCount(); i++) {
            workers.add(new Worker(company.getFreeDepartment(i), BARRIER ));
        }
    }
    public void start() {
        for (final Runnable worker : workers) {
            new Thread(worker).start();
        }
    }

    public static void main(String[] args) {
        Company company = new Company(10);
        Founder founder = new Founder(company);
        founder.start();
    }
}