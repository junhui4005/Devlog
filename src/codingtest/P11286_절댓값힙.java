package src.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class P11286_절댓값힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(bufferedReader.readLine());
        Queue<Integer> q = new PriorityQueue<>((o1, o2) ->{
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs){
                return o1 > o2 ? 1 : -1; // 절댓값 같은 경우 음수 우선
            }
            return first_abs - second_abs;// 절댓값 작은 데이터 우선
        });
        for(int i = 1; i <= N; i++){
            int request = Integer.parseInt(bufferedReader.readLine());
            if(request == 0){
                if(q.isEmpty()){
                    System.out.println(0);
                }
                else{
                    System.out.println(q.poll());
                }
            }else{
                q.add(request);
            }
        }
    }
}
