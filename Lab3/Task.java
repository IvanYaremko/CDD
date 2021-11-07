package Lab3;

/**
 *
 * @Author Ivan Yaremko
 */
public class Task implements Runnable {

    /**
     * Name of the task
     */
    String name;
    /**
     * ReusableBarrier object
     */
    ReusableBarrier barrier;

    /**
     * Constructor
     * @param tName name of the object
     * @param rBarrier the ReusableBarrier object
     */
    Task(String tName, ReusableBarrier rBarrier) {
        this.name = tName;
        this.barrier = rBarrier;
    }

    /**
     * Runnable method
     */
    @Override
    public void run() {
              barrier.barrier(this);
    }
}
