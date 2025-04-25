package src.codingtest;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// 큐를 이용한 카드 게임
public class Example_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int N = sc.nextInt();
        for(int i = 1; i <= N; i++){
            q.add(i);
        }
        while(q.size() > 1){ // 하나 남을 때까지 무한 루프
            q.poll();
            int temp = q.poll(); // 버린 데이터를 읽음
            q.add(temp);
        }
        System.out.println(q.poll()); // 맨 마지막에 버리는 데이터
    }
}
