package src.cs.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 뮤텍스 락을 이용한 동기화 클래스
public class Mutex {
    static int sharedData = 0;
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Increment());
        Thread thread2 = new Thread(new Decrement());

        thread1.start(); // 첫번째 스레드 시작
        thread2.start(); // 두번째 스레드 시작

        try{
            thread1.join(); // 첫번째 스레드 종료 대기
            thread2.join(); // 두번째 스레드 종료 대기
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        // 최종 공유 데이터 값 출력
        System.out.println("Final value of sharedData: "+sharedData); // Final value of sharedData: 0
    }

    static class Increment implements Runnable {
        public void run() {
            for(int i = 0; i < 100000; i++){
                lock.lock(); // 락 획득
                try{
                    sharedData++; // 공유데이터 증가
                } finally {
                    lock.unlock(); // 락 해제
                }
            }
        }
    }

    static class Decrement implements Runnable {
        public void run() {
            for(int i = 0; i < 100000; i++){
                lock.lock(); // 락 획득
                try{
                    sharedData--; // 공유데이터 감소
                } finally {
                    lock.unlock(); // 락 해제
                }
            }
        }
    }
}
