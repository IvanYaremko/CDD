package Lab7;

import java.util.concurrent.Semaphore;

/**
 * @Author Ivan Yaremko
 * @Reference Downey, A., 2016. The Little Book of Semaphores.
 */
public class Table {
    /**
     * The footman overseas which philosopher gets to pick up forks and eat.
     * Only 4 philosopher objects can attempt to pick up the forks at a time.
     * The footman is used to prevent a deadlock.
     */
    Semaphore footman = new Semaphore(4);
    /**
     * This stores the array of forks.
     */
    Semaphore[] forks;

    /**
     * The constructor initialises the table and the forks semaphore array.
     * @param sForks
     */
    Table(Semaphore[] sForks){
        this.forks = sForks;
    }

    /**
     * The method is used by a philosopher object to pick up
     * the left and right fork on the table so that they can eat.
     * The footman supervises the table to make sure a philosopher can pick up a fork only if the
     * left and right fork is free.
     * The real responsibility of the footman is to prevent a deadlock from occurring.
     * @param i Which fork to pick up, the table position of the philosopher.
     * @param phil The philosopher currently attempting to pick up the forks.
     * @throws InterruptedException
     */
    void get_forks(int i, Philosopher phil) throws InterruptedException {
        /**
         * Footman supervises the table.
         */
        footman.acquire();
        System.out.println(phil.name + " is eating.");
        forks[right(i)].acquire();
        forks[left(i)].acquire();
    }

    /**
     * The method is used by a philosopher object to put down their forks.
     * The philosopher releases the right and left fork (semaphore) from their current table position.
     * @param i Which fork to put down, the table position of the philosopher.
     * @param phil
     */
    void put_forks(int i, Philosopher phil){
        forks[right(i)].release();
        forks[left(i)].release();
        System.out.println(phil.name + " is finished eating");
        footman.release();
    }

    /**
     * Returns the passed integer number back.
     * @param i
     * @return
     */
    private int left(int i){
        return i;
    }

    /**
     * The % operator wraps around when it gets to 5, so (4+1) % 5 = 0
     * @param i integer number
     * @return
     */
    private int right(int i){
        return (i+1) % 5;
    }

}
