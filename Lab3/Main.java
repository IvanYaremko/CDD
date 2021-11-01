package Lab3;

/**
 * @author ivan yaremko
 */

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        // Create a reusable barrier object
        ReusableBarrier rBarrier = new ReusableBarrier(4);

        // Create 4 tasks
        Runnable r1 = new Task("task 1",rBarrier);
        Runnable r2 = new Task("task 2",rBarrier);
        Runnable r3 = new Task("task 3",rBarrier);
        Runnable r4 = new Task("task 4",rBarrier);

        // creates a thread pool
        ExecutorService pool = Executors.newFixedThreadPool(4);

        // passes the Task objects to the pool to execute (Step 3)
        pool.execute(r1);
        pool.execute(r2);
        pool.execute(r3);
        pool.execute(r4);

        // pool shutdown
        pool.shutdown();


    }
}
