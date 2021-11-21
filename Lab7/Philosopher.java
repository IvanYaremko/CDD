package Lab7;

/**
 * @Author Ivan Yaremko
 */
public class Philosopher implements Runnable{
    /**
     * This stores the name of the philosopher
     */
    String name;
    /**
     * This stores the table object each philosopher dines in
     */
    Table table;
    /**
     * This stores the table position the philosopher sits in
     */
    int tablePosition;

    /**
     * This constructor initialises the Philosopher object.
     * @param tName The name of the philosopher.
     * @param tbl The table which the philosopher dines at.
     * @param tPos The position on the table the philosopher eats at.
     */
    Philosopher(String tName, Table tbl, int tPos){
        this.name = tName;
        this.table = tbl;
        this.tablePosition = tPos;
    }

    /**
     * This runnable method gets the philosopher to pick up forks to eat,
     * sleeps for 5 seconds, then gets the philosopher to put down the forks.
     */
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
