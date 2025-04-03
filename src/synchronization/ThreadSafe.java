package src.synchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

// 스레드 안전성 확인
// ArrayList와 Vector 클래스의 동기화 여부 확인
public class ThreadSafe {
    public static void main(String[] args) throws InterruptedException {
        //
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> vector = new Vector<>();

        Thread arrayListThread1 = new Thread(() -> addElements(arrayList, 0, 5000));
        Thread arrayListThread2 = new Thread(() -> addElements(arrayList, 5000, 10000));

        Thread vectorThread1 = new Thread(() -> addElements(vector, 0, 5000));
        Thread vectorThread2 = new Thread(() -> addElements(vector, 5000, 10000));

        arrayListThread1.start();
        arrayListThread2.start();
        vectorThread1.start();
        vectorThread2.start();

        arrayListThread1.join();
        arrayListThread2.join();
        vectorThread1.join();
        vectorThread2.join();

        System.out.println("ArrayList size: " + arrayList.size());  // ArrayList size: 6949
        System.out.println("Vector size: " + vector.size()); // Vector size: 10002

    }

    public static void addElements(List<Integer> list, int start, int end) {
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
    }
}
