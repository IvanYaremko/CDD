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
class IntegerObj {
    /**
     * Here the integer value from the constructor is stored
     */
    int value;

    /**
     * Constructor to initialise the object
     * @param val - Integer value of the object
     */
    IntegerObj(int val) {
        this.value = val;
    }

    /**
     * Synchronized Method to increment the value by one
     * @return - Returns the current value integer variable
     */
    synchronized int inc(){
        this.value++;
        return this.value;
    }
}
