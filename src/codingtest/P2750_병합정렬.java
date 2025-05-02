package src.codingtest;

import java.util.Scanner;

public class P2750_병합정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();              // 입력 개수
        int[] result = new int[n];         // 배열 생성
        for (int i = 0; i < n; i++) {
            result[i] = sc.nextInt();      // 배열 값 입력
        }
        mergeSort(result, 0, n - 1);       // 병합 정렬 호출
        // 결과 출력
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
    // 병합 정렬 메서드
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 왼쪽과 오른쪽 분할하여 정렬
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            // 병합
            merge(arr, left, mid, right);
        }
    }
    // 병합 메서드
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;      // 왼쪽 배열 인덱스
        int j = mid + 1;   // 오른쪽 배열 인덱스
        int k = 0;         // 임시 배열 인덱스

        // 작은 값부터 임시 배열에 저장
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        // 남은 왼쪽 부분 복사
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        // 남은 오른쪽 부분 복사
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // 정렬된 결과 원본 배열에 복사
        for (int t = 0; t < temp.length; t++) {
            arr[left + t] = temp[t];
        }
    }
}
