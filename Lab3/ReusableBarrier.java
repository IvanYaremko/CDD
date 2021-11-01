package Lab3;

import java.util.concurrent.Semaphore;

public class ReusableBarrier {
    Semaphore mutex = new Semaphore(1);
    Semaphore turnstile = new Semaphore(0);
    Semaphore turnstile2 = new Semaphore(1);
    int count = 0;
    int n;

    ReusableBarrier(int nThreads){
        this.n = nThreads;
    }

    void barrier(Task t)
    {
        System.out.println(t.name + " has arrived");
        try {

            mutex.acquire();
            count++;
            if(count == n){
                turnstile2.acquire();
                turnstile.release();
            }
            mutex.release();

            turnstile.acquire();
            turnstile.release();

            System.out.println(t.name + " past first turnstile");

            mutex.acquire();
            count -= 1;
            if(count == 0){
                turnstile.acquire();
                turnstile2.release();
            }
            mutex.release();

            turnstile2.acquire();
            turnstile2.release();

            System.out.println(t.name + " pas second turnstile");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
