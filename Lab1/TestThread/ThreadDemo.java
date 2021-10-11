//*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
package Lab1.TestThread;

/**
 *
 * @author KEHOEJ
 */
class ThreadDemo extends Thread {
    //fields and methods
    /**
     * Here is where we put our thread created by start() method
     */
   private Thread t;
   /**
    * Every thread is given a name
    */
   private String threadName;

   /**
    * Constructor that initialises the thread class
    * And prints the name of the thread to the system.
    * @param name - Name of the thread
    */
   ThreadDemo( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }
   
   @Override
   public void run() {
       /**
        * Prints out start of thread message
        */
      System.out.println("Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
             /**
              * Prints out message four times
              */
            System.out.println("Thread: " + threadName + ", " + i);
            // Let the thread sleep for a while.
            Thread.sleep(50);
         }
      } catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      /**
       * Prints exit message
       */
      System.out.println("Thread " +  threadName + " exiting.");
   }

   /**
    * The method starts a thread name, prints the thread name.
    */
   @Override
   public void start () {
      /**
       * Prints the thread name at the start of the thread lifecycle
       */
      System.out.println("Starting " +  threadName );
      /**
       * Method checks if the thread object points to a thread
       * If condition is true, a new thread is invoked and 't' is used as a reference to that thread.
       */
      if (t == null) {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
}
