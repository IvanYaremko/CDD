/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2.mutexcode;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author joe
 */
class IntegerObj {
    /**
     * Here the integer value from the constructor is stored
     */
    int value;

    private ReentrantLock mutex = new ReentrantLock();

    /**
     * Constructor to initialise the object
     * @param val - Integer value of the object
     */
    IntegerObj(int val) {
        this.value = val;
    }

    /**
     * Method to increment the value by one
     * A mutex lock is used in the critical section
     * @return - Returns the current value integer variable
     */
     int inc(){
         try{
             mutex.lock();
             this.value++;
         }finally {
             mutex.unlock();
             return this.value;
         }
    }
}
