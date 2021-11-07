package Lab5;

/**
 * @Author Ivan Yaremko
 *
 * A simple Task class that implements Runnable interface.
 */
public class Task implements Runnable{
    /**
     * Stores the letter of a leader or follower
     */
    char name;
    /**
     * Stores the LeaderFollower object
     */
    LeaderFollower lf;

    /**
     * Contructor
     * @param tName either letter for Leader or number for Follower
     * @param leaderFollower The LeaderFollower object all tasks will be able to access
     */
    Task(char tName, LeaderFollower leaderFollower){
        this.name = tName;
        this.lf = leaderFollower;
    }


    /**
     * The runnable implmentation
     */
    @Override
    public void run() {
        try {
            lf.danceParty(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
