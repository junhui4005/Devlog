package src.java;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("사과");
        linkedList.add("바나나");
        linkedList.add("체리");

        System.out.println("LinkedList 출력:");
        for (String fruit : linkedList) {
            System.out.println(fruit);
        }

        // 인덱스로 접근
        System.out.println("2번째 과일: " + linkedList.get(1)); // 바나나
    }
}
