package src.codingtest.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold_V_P1717 {
    static int [] K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = new int[N+1]; // 0부터 시작이므로
        for (int i = 0; i < N+1; i++) {
            K[i] = i; // 일단 배열담기
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0){
                union(b,c);
            }else{
                boolean check = checkSum(b,c);
                if(check){System.out.println("YES");}else{System.out.println("NO");}
            }
        }
    }

    private static void union(int b, int c) {
        b = find(b);
        c = find(c);

        if(b != c){
            K[b] = c; // 방향이 달라도 상관없음 ex) K[c] = b;
        }
    }

    private static int find(int find){
        if(find == K[find]){
            return find;
        }
        return K[find] = find(K[find]);
    }

    private static boolean checkSum(int b, int c) {
        b = find(b);
        c = find(c);
        if(b != c){
            return false;
        }
        return true;
    }
}
