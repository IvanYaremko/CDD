package Lab6;

/**
 * @Author Ivan Yaremko
 */
public class Producer implements Runnable{
    /**
     * The name of the consumer object
     */
    String name;
    /**
     * The buffer object each task accesses
     */
    Buffer buffer;

    /**
     * Constructor
     * @param name Name of the thread
     * @param buffer The buffer object
     */
    public Producer(String name, Buffer buffer) {
        this.name = name;
        this.buffer = buffer;
    }

    /**
     * Runnable method.
     * Invokes the consume method in the buffer class, passes this consumer task along its agruments.
     */
    @Override
    public void run() {
        try {
            buffer.produce(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
