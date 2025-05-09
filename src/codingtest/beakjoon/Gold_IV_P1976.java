package src.codingtest.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gold_IV_P1976 {
    static int [] K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        boolean check= true;
        K = new int[N+1];
        for(int i = 1; i <= N; i++){
            K[i] = i;
        }
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                if(st.nextToken().equals("1")){
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        for(int i = 1; i < M; i++){
            int b = Integer.parseInt(st.nextToken());
            if(find(a) != find(b)){
                check = false;
            }
            a = b;
        }

        if(check){
            System.out.println("YES");
        }else System.out.println("NO");
    }

    static void union(int i, int j){
        i = find(i);
        j = find(j);
        if(i != j) {
            K[i] = j;
        }
    }

    static int find(int i){
        if(K[i] == i) return i;
        return K[i] = find(K[i]);
    }
}
