package src.synchronization;

public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " - Count: " + count);
    }

    public int getCount() {
        return count;
    }
}
