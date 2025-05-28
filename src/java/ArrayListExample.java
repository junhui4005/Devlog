package src.java;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("사과");
        arrayList.add("바나나");
        arrayList.add("체리");

        System.out.println("ArrayList 출력:");
        for (String fruit : arrayList) {
            System.out.println(fruit);
        }

        // 인덱스로 접근
        System.out.println("2번째 과일: " + arrayList.get(1)); // 바나나
    }
}

