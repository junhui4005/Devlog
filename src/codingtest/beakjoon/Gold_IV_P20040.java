package src.codingtest.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold_IV_P20040 {
    static int [] A;
    static boolean check = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        for(int i = 0; i <= N; i++){
            A[i] = i;
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
            if(!check){
                System.out.println(i+1);
                break;
            }
        }
        if(check){
            System.out.println(0);
        }
    }

    private static void union(int i, int j){
        i = find(i);
        j = find(j);
        if(i != j){
            A[i] = j;
        }else {
            check = false;
        }
    }
    private static int find(int i){
        if(A[i] == i) return i;
        return A[i] = find(A[i]);
    }
}
