package Lab3;

public class Task implements Runnable {
    String name;
    ReusableBarrier barrier;

    Task(String tName, ReusableBarrier rBarrier) {
        this.name = tName;
        this.barrier = rBarrier;
    }

    @Override
    public void run() {
              barrier.barrier(this);
    }
}
