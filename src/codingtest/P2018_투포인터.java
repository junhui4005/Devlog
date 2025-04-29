package src.codingtest;

import java.util.Scanner;

// 투 포인터
public class P2018_투포인터 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 1; // N 값 자기자신 포함
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        while (end_index != N) {
            System.out.println("start_index: " + start_index + ", end_index: " + end_index + ", sum: " + sum);
            if (sum == N) {
                count++;
                end_index++;
                sum = sum + end_index;
            } else if (sum > N) {
                sum = sum - start_index;
                start_index++;
            } else {
                end_index++;
                sum = sum + end_index;
            }
        }
        System.out.println(count);
    }
}
