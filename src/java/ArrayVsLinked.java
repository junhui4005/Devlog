package src.java;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayVsLinked {
    public static void main(String[] args) {
        int size = 10000;

        // ArrayList 성능 테스트
        ArrayList<Integer> arrayList = new ArrayList<>();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.add(0, i); // 앞에 삽입
        }
        long end1 = System.currentTimeMillis();
        System.out.println("ArrayList 삽입 시간: " + (end1 - start1) + "ms");

        // LinkedList 성능 테스트
        LinkedList<Integer> linkedList = new LinkedList<>();
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            linkedList.add(0, i); // 앞에 삽입
        }
        long end2 = System.currentTimeMillis();
        System.out.println("LinkedList 삽입 시간: " + (end2 - start2) + "ms");
    }
}
