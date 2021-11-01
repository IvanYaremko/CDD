package Lab5;

import java.util.concurrent.Semaphore;

public class LeaderFollower {
    Semaphore leaderQ = new Semaphore(0);
    Semaphore followerQ = new Semaphore(0);

    LeaderFollower(){
    }

    void danceParty(Task t) throws InterruptedException {
        // Leader
        if(t.name >= 'A' && t.name <= 'Z'){
            followerQ.release();
            leaderQ.acquire();
            System.out.print(t.name);
        }
        // Follower
        else{
            leaderQ.release();
            followerQ.acquire();
            System.out.print(t.name);
        }
    }
}
