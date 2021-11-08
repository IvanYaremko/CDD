package Lab5;

/**
 * @Author Ivan Yaremko
 */
public class Follower implements Runnable{
    /**
     * Name of the task
     */
    String name;
    /**
     * The queue object
     */
    Queue queue;

    /**
     * Constructor
     * @param fName name of the object
     * @param q The queue object
     */
    Follower(String fName,  Queue q){
        this.name = fName;
        this.queue = q;
    }

    /**
     * The runnable method.
     * This follower task invokes the waitForLeader() method 10 times in a loop.
     */
    @Override
    public void run() {
        try {
            for(int i = 0; i<10; i++){
                queue.waitForLeader(this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
