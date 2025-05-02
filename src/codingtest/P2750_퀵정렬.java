package src.codingtest;

import java.util.Scanner;

public class P2750_퀵정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();              // 입력 개수
        int[] result = new int[n];         // 배열 생성

        for (int i = 0; i < n; i++) {
            result[i] = sc.nextInt();      // 배열 값 입력
        }

        // 퀵정렬 호출
        quickSort(result, 0, n - 1);

        // 결과 출력
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }

    // 퀵정렬 메서드
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // 분할 기준
            quickSort(arr, low, pivotIndex - 1);        // 왼쪽 정렬
            quickSort(arr, pivotIndex + 1, high);       // 오른쪽 정렬
        }
    }

    // 분할 메서드
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];   // 피벗: 마지막 원소
        int i = low - 1;         // 피벗보다 작은 값의 끝 인덱스

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // swap arr[i]와 arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 피벗을 정렬된 위치로 이동
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
