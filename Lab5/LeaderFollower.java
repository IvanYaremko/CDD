package Lab5;

import java.util.concurrent.Semaphore;

/**
 * @Author Ivan Yaremko
 *
 * LeaderFollower class implementation
 */
public class LeaderFollower {
    /**
     * Initialise the leader queue semaphore
     */
    Semaphore leaderQ = new Semaphore(0);
    /**
     * Initialise the follower queue semaphore
     */
    Semaphore followerQ = new Semaphore(0);

    /**
     * Empty constructor
     */
    LeaderFollower(){
    }

    /**
     * This method is the critical section that all tasks will enter when they get executed.
     * @param t The current Task executing in the critical section
     * @throws InterruptedException
     */
    void danceParty(Task t) throws InterruptedException {
        /**
         * The leaders enter here
         */
        if(t.name >= 'A' && t.name <= 'Z'){
            /**
             * A leader gets a lock on the leader queue and unlocks the follower queue.
             * If there is a follower waiting for a leader then the pair gets to dance
             */
            followerQ.release();
            leaderQ.acquire();
            System.out.print(t.name);
        }
        /**
         * The followers enter here
         */
        else{
            /**
             * A Follower unlocks the leader queue and lock the follower queue
             * If there is a leader waiting for a follower then the pair gets to dance
             */
            leaderQ.release();
            followerQ.acquire();
            System.out.print(t.name);
        }
    }
}
