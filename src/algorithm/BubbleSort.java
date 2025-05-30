package src.algorithm;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4, 2, 8};

        bubbleSort(arr);

        System.out.println("정렬 결과:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void bubbleSort(int [] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                // 인접한 두 수 비교해서 순서 바꾸기
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
