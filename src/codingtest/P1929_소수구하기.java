package src.codingtest;

import java.util.Scanner;

public class P1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int [] A = new int[N+1];
        for (int i = 2; i <= N; i++) { // 1은 소수가 아니므로 2부터~
            A[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(N); i++) {  // 만약 N이 30아면 Math.sqrt(30) = 5.477~이기 때문에 <=5
            if(A[i] == 0){
                continue;
            }
            for (int j = i+i; j <= N; j = j+i) {
                System.out.println("i: "+ i +", j: "+ j + " A[j]: " + A[j] + " ");
                A[j] = 0;
            }
        }
        for (int i = M; i <= N; i++) {
            if(A[i] != 0){
                System.out.println(A[i]);
            }
        }
    }
}
