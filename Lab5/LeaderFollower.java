package Lab5;

import java.util.concurrent.Semaphore;

public class LeaderFollower {
    int leader = 0;
    int followers = 0;
    Semaphore mutex = new Semaphore(1);
    Semaphore leaderQ = new Semaphore(0);
    Semaphore followerQ = new Semaphore(0);
    Semaphore rendezvous = new Semaphore(0);

    LeaderFollower(){

    }

    void danceParty(Task t){
        // Leader
        if(t.name.compareTo("A") > 0 && t.name.compareTo("Z") <0){

        }
        // Follower
        else{

        }
    }

}
