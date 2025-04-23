package src.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // 속도가 더 빠름
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // 문자열이 길 경우 사용

        int suNo = Integer.parseInt(stringTokenizer.nextToken()); // ex) 5
        int quizNo = Integer.parseInt(stringTokenizer.nextToken()); // ex) 3
        long [] S = new long [suNo + 1]; // 0번째 인덱스를 무시하고 질의하고자 한다.

        stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // ex) 5 4 3 2 1
        for(int i = 1; i <= suNo; i++){
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken()); // ex) 5 9 12 14 15
        }
        for(int i = 0; i < quizNo; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken()); // ex) 1
            int b = Integer.parseInt(stringTokenizer.nextToken()); // ex) 3
            System.out.println(S[b] - S[a-1]); // ex) 12 - 0
        }
    }
}