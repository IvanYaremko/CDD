package Lab6;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * @Author Ivan Yaremko
 *
 * This Buffer class implements the buffer producer-consumer solution
 */
public class Buffer {
    /**
     * Semaphore used as a mutex lock for critical sections
     */
    Semaphore mutex = new Semaphore(1);
    /**
     * Semaphore used to store the amount of items there is to consume
     */
    Semaphore items = new Semaphore(0);
    /**
     * Semaphore used to store the amount of space the buffer has
     */
    Semaphore spaces;
    /**
     * This LL is used as an event object
     */
    LinkedList<String> event = new LinkedList<>();

    /**
     * Constructor
     * @param bufferSize the size of the buffer
     */
    public Buffer(int bufferSize) {
        spaces = new Semaphore(bufferSize);
    }

    /**
     * This method is invoked by producer objects to produce an item.
     * The event that occurs is the adding of the producers name into a LinkedList
     * @param producer the producer object
     * @throws InterruptedException
     */
    void produce(Producer producer) throws InterruptedException {

        spaces.acquire();
        mutex.acquire();
        event.add(producer.name);
        System.out.println(producer.name + " added");
        mutex.release();
        items.release();
    }

    /**
     * This method is invoked by consumer objects to consume items.
     * The event that occurs is the removal of a tasks name from the LinkedList
     * @param consumer The consumer object.
     * @throws InterruptedException
     */
    void consume(Consumer consumer) throws InterruptedException {

        items.acquire();
        mutex.acquire();
        String name = event.removeFirst();
        System.out.println(consumer.name + " removed " + name);
        mutex.release();
        spaces.release();

    }
}
