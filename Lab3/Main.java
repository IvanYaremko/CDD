package Lab3;



public class Main {
    public static void main(String[] args) {
        ReusableBarrier rBarrier = new ReusableBarrier(4);
        Runnable r1 = new Task("task 1",rBarrier);
        Runnable r2 = new Task("task 2",rBarrier);
        Runnable r3 = new Task("task 3",rBarrier);
        Runnable r4 = new Task("task 4",rBarrier);

        r1.run();
        r2.run();
        r3.run();
        r4.run();

    }
}
