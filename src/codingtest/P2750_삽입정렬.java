package src.codingtest;

import java.util.Scanner;

public class P2750_삽입정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();              // 입력 개수
        int[] result = new int[n];         // 배열 생성

        for (int i = 0; i < n; i++) {
            result[i] = sc.nextInt();      // 배열 값 입력
        }

        // 삽입 정렬
        for (int i = 1; i < n; i++) {
            int value = result[i];
            int j = i;

            while (j > 0 && result[j - 1] > value) {
                result[j] = result[j - 1];
                j--;
            }

            result[j] = value;
        }
        // 결과 출력
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}
