package src.codingtest;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// 투 포인터
public class Example_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int [] c = new int [a];
        for (int i = 0; i < a; i++) {
            int nextToken = Integer.parseInt(stringTokenizer.nextToken());
            c[i] = nextToken;
        }
        Arrays.sort(c); // Arrays 순서대로

        int count = 0;
        int i = 0;
        int j = a-1;
        while (i < j) {
            if(c[i]+ c[j] == b) {
                count++;
                i++;
                j--;
            }
            else if(c[i] + c[j] > b) {
                j -= 1;
            }
            else {
                i += 1;
            }
        }
        System.out.println(count);
    }
}
