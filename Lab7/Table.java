package Lab7;

import java.util.concurrent.Semaphore;

public class Table {
    Semaphore footman = new Semaphore(4);
    Semaphore[] forks;

    Table(Semaphore[] sForks){
        this.forks = sForks;
    }

    void get_forks(int i, Philosopher phil) throws InterruptedException {
        footman.acquire();
        System.out.println(phil.name + " is eating.");
        forks[right(i)].acquire();
        forks[left(i)].acquire();
    }

    void put_forks(int i, Philosopher phil){
        forks[right(i)].release();
        forks[left(i)].release();
        System.out.println(phil.name + " is finished eating");
        footman.release();
    }

    private int left(int i){
        return i;
    }

    private int right(int i){
        return (i+1) % 5;
    }

}
