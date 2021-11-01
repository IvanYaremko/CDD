package Lab5;

public class Task implements Runnable{
    String name;
    LeaderFollower lf;

    Task(String tName, LeaderFollower leaderFollower){
        this.name = tName;
        this.lf = leaderFollower;
    }



    @Override
    public void run() {
        lf.danceParty(this);
    }
}
