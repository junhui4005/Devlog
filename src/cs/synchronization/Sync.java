package src.cs.synchronization;

// Synchronized 동기화 클래스. Counter 클래스 연계
public class Sync {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Count: " + counter.getCount());
        /*
        Thread-1 - Count: 1
        Thread-2 - Count: 2
        Thread-1 - Count: 3
        Thread-2 - Count: 4
        Thread-1 - Count: 5
        Thread-2 - Count: 6
        Thread-1 - Count: 7
        Thread-2 - Count: 8
        Thread-1 - Count: 9
        Thread-2 - Count: 10
        Final Count: 10
        * */
    }
}
