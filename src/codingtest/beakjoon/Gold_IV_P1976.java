package src.codingtest.beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold_IV_P1976 {
    static int [] K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = new int[N+1];
        for(int i = 1; i <= N; i++){
            K[i] = i;
        }
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){

            }

        }
    }
}
