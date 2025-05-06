package src.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1707_이분그래프 {
    static ArrayList<Integer>[] A; // 인접 리스트: 각 정점에 연결된 노드들을 저장
    static int [] check;           // 노드마다 집합 정보 저장 (0 또는 1)
    static boolean [] visited;     // 방문 여부 확인
    static boolean isEven;         // 이분 그래프 여부를 판단하는 플래그
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for(int t = 0; t < testCase; t++) { // 주어진 테스트 케이스 만큼 돌림
            String [] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V+1];
            visited = new boolean[V+1];
            check = new int [V+1];
            isEven = true;
            for(int i = 1; i <= V; i++) {
                A[i] = new ArrayList<Integer>();
            }
            // 에지 데이터 저장하기
            for(int i =  0; i < E; i++){
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }
            // 모든 노드에서 DFS 실행해야함
            for(int i = 1; i <= V; i++) {
                if(isEven && !visited[i]) {
                   DFS(i);
                }else {
                    break;
                }
            }

            if(isEven) {
                System.out.println("YES");
            }else System.out.println("NO");
        }
    }

    private static void DFS(int start) {
        visited[start] = true;
        System.out.println(start + " "+ A[start] );
        for(int i : A[start]) {
            System.out.println("visit: " + i + " visited["+i+"]: " + visited[i]);
            if(!visited[i]){
                // 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는 것이 필요
                System.out.println("check["+i+"]: " + check[i] + " check["+start+"]: " + check[start]);
                check[i] = (check[start] + 1) % 2;
                DFS(i);
            }else if (check[start] == check[i]) {
                isEven = false;
            }
        }
    }
}
