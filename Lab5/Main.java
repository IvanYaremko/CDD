package Lab5;



import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        LeaderFollower lf = new LeaderFollower();



        // Create 4 tasks
        Runnable r1 = new Task('A',lf);
        Runnable r2 = new Task('B',lf);
        Runnable r3 = new Task('C',lf);
        Runnable r4 = new Task('D',lf);
        Runnable r5 = new Task('E',lf);
        Runnable r6 = new Task('F',lf);
        Runnable r7 = new Task('1',lf);
        Runnable r8 = new Task('2',lf);
        Runnable r9 = new Task('3',lf);
        Runnable r10 = new Task('4',lf);
        Runnable r11 = new Task('5',lf);
        Runnable r12 = new Task('6',lf);


        // creates a thread pool
        ExecutorService pool = Executors.newFixedThreadPool(12);

        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);
        pool.execute(r5);
        pool.execute(r6);
        pool.execute(r7);
        pool.execute(r8);
        pool.execute(r9);
        pool.execute(r10);
        pool.execute(r11);
        pool.execute(r12);
        // pool shutdown
        pool.shutdown();

    }
}
