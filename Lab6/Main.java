package Lab6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @Author Ivan Yaremko
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Initialise the buffer object, set buffer capacity to N amount
         */
        Buffer buffer = new Buffer(1);

        /**
         * Create 6 producers and 6 consumers
         */
        Producer p1 = new Producer("p1", buffer);
        Producer p2 = new Producer("p2", buffer);
        Producer p3 = new Producer("p3", buffer);
        Producer p4 = new Producer("p4", buffer);
        Producer p5 = new Producer("p5", buffer);
        Producer p6 = new Producer("p6", buffer);

        Consumer c1 = new Consumer("c1", buffer);
        Consumer c2 = new Consumer("c2", buffer);
        Consumer c3 = new Consumer("c3", buffer);
        Consumer c4 = new Consumer("c4", buffer);
        Consumer c5 = new Consumer("c5", buffer);
        Consumer c6 = new Consumer("c6", buffer);

        /**
         * ExecuterService used to execute the producer and consumer tasks
         */
        ExecutorService pool = Executors.newFixedThreadPool(12);
        pool.execute(p1);
        pool.execute(p2);
        pool.execute(p3);
        pool.execute(p4);
        pool.execute(p5);
        pool.execute(p6);
        pool.execute(c1);
        pool.execute(c2);
        pool.execute(c3);
        pool.execute(c4);
        pool.execute(c5);
        pool.execute(c6);

        /**
         * Shutdown the pool
         */
        pool.shutdown();
    }
}
