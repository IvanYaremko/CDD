package Lab5;

/**
 * @Author Ivan Yaremko
 */
public class Leader implements Runnable {
    /**
     * The name of the Leader task
     */
    String name;
    /**
     * The queue object this task accesses
     */
    Queue queue;

    /**
     * Constructor
     * @param lName Name of the task
     * @param q the queue object
     */
    Leader(String lName, Queue q){
        this.name = lName;
        this.queue = q;
    }

    /**
     * Runnable method, loops 10 times.
     * This leader tasks invokes the waitForFollower method.
     */
    @Override
    public void run() {
        try {
            for(int i = 0; i<10; i++){
                queue.waitForFollower(this);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
