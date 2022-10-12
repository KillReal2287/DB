package Homework6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public final class Founder {
    private final List<Runnable> workers;
     Company company;
     int workers_count;
     private CyclicBarrier Barrier;

    public Founder(final Company company) {
        this.company = company;
        this.workers = new ArrayList<>(company.getDepartmentsCount());
        this.workers_count = company.getDepartmentsCount();
        Barrier = new CyclicBarrier(workers_count, new Runnable() {
            @Override
            public void run() {
                company.showCollaborativeResult();
            }
        });

        for (int i = 0; i < company.getDepartmentsCount(); i++) {
            workers.add(new Worker(company.getFreeDepartment(i), Barrier));
        }
    }

    public void start() {
        for (final Runnable worker : workers) {
            new Thread(worker).start();
        }
    }

    public static void main(String[] args) {
        Company company = new Company(1);
        Founder founder = new Founder(company);
        founder.start();
    }
}