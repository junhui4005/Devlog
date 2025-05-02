package src.codingtest;

import java.util.Scanner;

public class P2750_기수정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();              // 입력 개수
        int[] arr = new int[n];            // 배열 생성
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();         // 배열 값 입력
        }
        radixSort(arr);                    // 기수 정렬 수행
        // 결과 출력
        for (int num : arr) {
            System.out.println(num);
        }
    }

    // 기수 정렬 메서드
    public static void radixSort(int[] arr) {
        int max = getMax(arr);             // 가장 큰 수 찾기 → 최대 자릿수 결정
        // 자릿수마다 정렬 수행 (1 → 10 → 100 → ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    // 자릿수 기준 계수 정렬 (안정 정렬)
    public static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];     // 정렬 결과 저장 배열
        int[] count = new int[10];     // 0~9 자릿수 카운팅 배열
        // 현재 자릿수 기준으로 count 배열 업데이트
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }
        // 누적 합을 이용한 위치 계산
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        // 출력 배열에 현재 자릿수 기준 정렬 결과 저장 (뒤에서부터 → 안정성 유지)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[--count[digit]] = arr[i];
        }
        // 정렬된 결과를 원본 배열로 복사
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // 배열에서 최대값 찾기
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
