package src.codingtest.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Lv1_택배상자꺼내기 {
    public static void main(String[] args) {
        int n = 22;
        int w = 6;
        int num = 8;

        Map<Integer, Stack<Integer>> stackMap = new HashMap<>();
        for(int i = 1; i <= w; i++){
            stackMap.putIfAbsent(i, new Stack<>());
        }
        for (int i = 1; i <= n; i++) {
            if(i / w % 2 == 0 && i % w != 0){
                stackMap.get(i%w).push(i);
            }else if(i / w % 2 != 0 && i % w != 0){
                stackMap.get(w-(i%w)+1).push(i);
            }else {
                if (i / w % 2 == 0 && i % w == 0){
                    stackMap.get(1).push(i);
                } else{
                    stackMap.get(w).push(i);
                }
            }
        }
        int count = 0;
        for (Integer i : stackMap.keySet()) {
            if(stackMap.get(i).contains(num)){
                while(!stackMap.get(i).empty()){
                    int pop = stackMap.get(i).pop();
                    count++;
                    if(pop == num){
                        break;
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(stackMap);
    }
}
