package Lab5;

import java.util.concurrent.Semaphore;

public class Queue {
    /**
     * Initialise the leaders and followers count to 0
     */
    int leaders, followers = 0;
    /**
     * Mutex semaphore used to lock the critical sections
     */
    Semaphore mutex = new Semaphore(1);
    /**
     * Semaphore used to keep track amount of leaders allowed to go
     */
    Semaphore leaderQueue = new Semaphore(0);
    /**
     * Semaphore used to keep track the amount of followers allowed to go.
     */
    Semaphore followerQueue = new Semaphore(0);
    /**
     * Semaphore used as a rendezvous
     */
    Semaphore rendezvous = new Semaphore(0);

    /**
     * This method is invoked by leader tasks.
     * The leader acquires the mutex,
     * checks if there are any followers waiting,
     * if true - lets a follower go dance
     * else - increments the amount of leaders waiting and takes the leaderQ lock.
     * @param leader The leader task object
     * @throws InterruptedException
     */
    void waitForFollower(Leader leader) throws InterruptedException {
        mutex.acquire();
        if(followers > 0){
            followers--;
            followerQueue.release();
        }else{
            leaders++;
            mutex.release();
            leaderQueue.acquire();
        }

        System.out.print(leader.name);
        rendezvous.acquire();
        mutex.release();
    }

    /**
     * This method is invoked by follower tasks.
     * The follower gets the lock on the critical section.
     * Checks if there are any leaders waiting to dance,
     * if true - lets a leader go dance
     * else - Increments the follower count and acquires the followerQ lock.
     * @param follower
     * @throws InterruptedException
     */
    void waitForLeader(Follower follower) throws InterruptedException {
        mutex.acquire();
        if(leaders>0){
            leaders--;
            leaderQueue.release();
        }else{
            followers++;
            mutex.release();
            followerQueue.acquire();
        }

        System.out.print(follower.name);
        rendezvous.release();
    }
}
