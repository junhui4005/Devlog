package src.codingtest;

import java.util.Scanner;

public class P11047_그리디 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] A = new int[n];
        for(int i = 0;i<n;i++){
            A[i] = sc.nextInt();
        }

        int count = 0;
        for(int i = n-1;i>=0;i--){
            if(A[i] <= m){
                count += (m/A[i]);
                m = m % A[i];
            }
        }
        System.out.println(count);
    }
}
