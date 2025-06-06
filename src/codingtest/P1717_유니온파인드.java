package src.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1717_유니온파인드 {
    static int parent [];
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(sc.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=0;i<=N;i++){
            parent[i] = i;
        }
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(sc.readLine());
            int question  = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            if(question == 0){
                union(a,b);
            }else {
                boolean result = checkSame(a,b);
                if(result){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }

    private static int find(int a){
        if(a == parent[a]) return a;
        else {
            return parent[a] = find(parent[a]);
        }
    }

    private static boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return true;
        return false;
    }
}
