package Lab7;

public class Philosopher implements Runnable{
    String name;
    Table table;
    int tablePosition;

    Philosopher(String tName, Table tbl, int tPos){
        this.name = tName;
        this.table = tbl;
        this.tablePosition = tPos;
    }

    @Override
    public void run() {
        try {
            table.get_forks(tablePosition, this);
            Thread.sleep(5000);
            table.put_forks(tablePosition, this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
