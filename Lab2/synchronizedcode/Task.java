/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2.synchronizedcode;

/**
 *
 * @author joe
 */
public class Task implements Runnable {
    /**
     *  Here the name of the task is stored
     */
    private String name;
    /**
     * Here the integer value from the constructor arguments are stored.
     */
    private IntegerObj total;

    /**
     * Constructor to initialise the task object
     * @param task_1 - Name of the task
     * @param total - Integer value
     */
    public Task(String task_1, IntegerObj total) {
        name=task_1;
        this.total = total;
    }

    /**
     * Runnable method
     */
    public void run()
    {
        try
        {
            /**
             * Loops 500 times, each loop increments the total.
             */
            for (int i = 0; i<500; i++)
            {
                total.inc();
                /**
                 * The thread is put to sleep for every 100th loop
                 */
                if (i%100==0){
                   Thread.sleep(100); 
                }
                
            }
            System.out.println(name+" complete");
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
