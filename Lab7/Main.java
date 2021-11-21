package Lab7;

/**
 * @Author Ivan Yaremko
 */

import java.lang.reflect.Array;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * The main class initialises all forks, philosopher and table semaphores.
 * The class creates an executor service pool to run each philosophers runnable.
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Creates an array of Semaphores and sets the size to 5.
         * Initialises each index with a semaphore of size 1
         */
        Semaphore[] theForks = new Semaphore[5];
        theForks[0] = new Semaphore(1);
        theForks[1] = new Semaphore(1);
        theForks[2] = new Semaphore(1);
        theForks[3] = new Semaphore(1);
        theForks[4] = new Semaphore(1);

        /**
         * Create a new table object.
         */
        Table table = new Table(theForks);

        /**
         * Initialise the philosophers, pass the table object and give each philosopher a table position.
         */
        Philosopher aristotle = new Philosopher("aristotle", table, 0);
        Philosopher plato = new Philosopher("plato", table, 1);
        Philosopher socrates = new Philosopher("socrates", table, 2);
        Philosopher epictetus = new Philosopher("epictetus", table, 3);
        Philosopher aurelius = new Philosopher("aurelius", table, 4);

        /**
         * ExecuterService used to execute the producer and consumer tasks
         */
        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.execute(aristotle);
        pool.execute(plato);
        pool.execute(socrates);
        pool.execute(epictetus);
        pool.execute(aurelius);


        /**
         * Shutdown the pool
         */
        pool.shutdown();
    }
}
