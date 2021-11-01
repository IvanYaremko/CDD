package Lab5;

public class Task implements Runnable{
    char name;
    LeaderFollower lf;

    Task(char tName, LeaderFollower leaderFollower){
        this.name = tName;
        this.lf = leaderFollower;
    }



    @Override
    public void run() {
        try {
            lf.danceParty(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
