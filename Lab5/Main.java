package Lab5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Ivan Yaremko
 */
public class Main {
    public static void main(String[] args) {
        /**
         * Create queue object where the leader-follower logic exists
         */
        Queue queue = new Queue();

        /**
         * Creaate leader + follower tasks and pass the queue object
         */
        Leader l1 = new Leader("A", queue);
        Leader l2 = new Leader("B", queue);
        Leader l3 = new Leader("C", queue);
        Leader l4 = new Leader("D", queue);
        Follower f1 = new Follower("1", queue);
        Follower f2 = new Follower("2", queue);
        Follower f3 = new Follower("3", queue);
        Follower f4 = new Follower("4", queue);

        /**
         * Create the service pool and execute the tasks
         */
        ExecutorService pool = Executors.newFixedThreadPool(8);
        pool.execute(l1);
        pool.execute(l2);
        pool.execute(l3);
        pool.execute(l4);
        pool.execute(f1);
        pool.execute(f2);
        pool.execute(f3);
        pool.execute(f4);

        /**
         * Shut down pool
         */
        pool.shutdown();

    }
}
