package src.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2252_위상정렬 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        int [] indegree = new int[N+1];
        for(int i = 0; i < M; i++){
            int S = sc.nextInt();
            int E = sc.nextInt();
            list.get(S).add(E);
            indegree[E]++; // 진입차수 배열 데이터 저장부분
        }
        // 위상정렬 실행
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            System.out.println(now + " ");
            for(int next : list.get(now)){
                indegree[next]--;
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
    }
}
