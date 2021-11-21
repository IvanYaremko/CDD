package Lab7;

import java.lang.reflect.Array;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore[] theForks = new Semaphore[5];
        theForks[0] = new Semaphore(1);
        theForks[1] = new Semaphore(1);
        theForks[2] = new Semaphore(1);
        theForks[3] = new Semaphore(1);
        theForks[4] = new Semaphore(1);

        Table table = new Table(theForks);

        Philosopher aristotle = new Philosopher("aristotle", table, 0);
        Philosopher plato = new Philosopher("plato", table, 1);
        Philosopher socrates = new Philosopher("socrates", table, 2);
        Philosopher epictetus = new Philosopher("epictetus", table, 3);
        Philosopher aurelius = new Philosopher("aurelius", table, 4);

        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.execute(aristotle);
        pool.execute(plato);
        pool.execute(socrates);
        pool.execute(epictetus);
        pool.execute(aurelius);

        pool.shutdown();
    }
}
