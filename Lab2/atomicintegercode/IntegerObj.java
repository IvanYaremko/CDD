/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab2.atomicintegercode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author joe
 */
class IntegerObj {
    /**
     * Here an Atomic Integer object is used as a counter
     */
    AtomicInteger value = new AtomicInteger();
    /**
     * Constructor to initialise the object
     * @param val - Integer value of the object
     */
    IntegerObj(AtomicInteger val) {
        this.value = val;
    }

    /**
     * Here the atomic integer object calls a method to increment and return total
     * @return - Returns the current value integer variable
     */
    int inc(){
        return value.incrementAndGet();
    }
}
