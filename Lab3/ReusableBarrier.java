package Lab3;

import java.util.concurrent.Semaphore;

/**
 * @Author Ivan Yaremko
 */
public class ReusableBarrier {
    /**
     * Mutex semaphore
     */
    Semaphore mutex = new Semaphore(1);
    /**
     * First turnstile semaphore
     */
    Semaphore turnstile = new Semaphore(0);
    /**
     * Second turnstile semaphore
     */
    Semaphore turnstile2 = new Semaphore(1);
    /**
     * Integer count variable
     */
    int count = 0;
    /**
     * Integer n variable to store the number of tasks
     */
    int n;

    /**
     * Constructor
     * @param nThreads stores the amount of threads that will access this object
     */
    ReusableBarrier(int nThreads){
        this.n = nThreads;
    }

    /**
     * The reusable barrier method
     * @param t the current task/thread accessing this method
     */
    void barrier(Task t)
    {
        System.out.println(t.name + " has arrived");
        try {
            /**
             * Thread acquires the lock
             */
            mutex.acquire();
            /**
             * Count is incremented to store the amount of threads that have entered
             */
            count++;
            /**
             * If the count matches the number of total threads that will enter,
             * The last expected thread has entered.
             */
            if(count == n){
                /**
                 * The last thread to pass through unlocks the first turnstile,
                 * and locks the second turnstile
                 */
                turnstile2.acquire();
                turnstile.release();
            }

            /**
             * Thread releases the lock, allows other threads to enter now
             */
            mutex.release();

            /**
             * The first thread locks the turnstile, all other threads coming here will be blocked from proceeding.
             */
            turnstile.acquire();
            turnstile.release();

            System.out.println(t.name + " past first turnstile");

            /**
             * Thread acquires the lock for this section
             */
            mutex.acquire();
            /**
             * Count is decremented to store the amount of threads that have left
             */
            count -= 1;
            if(count == 0){
                /**
                 * If count is equal to zero than the last thread has arrived.
                 * The last thread locks the first turnstile and unlocks the second to let all threads pass.
                 */
                turnstile.acquire();
                turnstile2.release();
            }

            /**
             * Thread releases the lock to the critical section.
             */
            mutex.release();

            /**
             * The first thread to hit here locks the turnstiles, all other threads reaching here wait until the
             * last thread unlock the turnstile.
             */
            turnstile2.acquire();
            turnstile2.release();

            System.out.println(t.name + " pas second turnstile");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
