package src.cs.synchronization;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// 조건변수 확인 클래스
public class CV {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static boolean ready = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadJob1());
        Thread thread2 = new Thread(new ThreadJob2());

        thread1.start(); // 첫번째 스레드 시작
        thread2.start(); // 두번째 스레드 시작

        try{
            thread1.join(); // 첫번째 스레드 종료 대기
            thread2.join(); // 두번째 스레드 종료 대기
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    static class ThreadJob1 implements Runnable {
        @Override
        public void run() {
            System.out.println("P1: 먼저 시작");
            lock.lock();
            try {
                System.out.println("P1: 2초 대기");
                while(!ready){
                    condition.await(); // 조건 변수 wait
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("P1: 다시 시작");
            System.out.println("P1: 종료");
        }
    }

    static class ThreadJob2 implements Runnable {
        public void run() {
            System.out.println("P2: 2초 먼저 시작");
            lock.lock();
            try {
                Thread.sleep(2000); // 2초 대기
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("P2: 실행 완료");
            lock.lock();
            try{
                ready = true;
                condition.signal();
            }finally {
                lock.unlock();
            }
        }
    }
}
/*
result:
P1: 먼저 시작
P2: 2초 먼저 시작
P1: 2초 대기
P2: 실행 완료
* */