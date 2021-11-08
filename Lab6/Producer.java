package Lab6;

public class Producer implements Runnable{
    String name;
    Buffer buffer;

    public Producer(String name, Buffer buffer) {
        this.name = name;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            buffer.produce(this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
