package src.codingtest.programmers;

import java.io.IOException;

public class Lv2_타겟넘버 {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        DFS(numbers,target,0,0);
        System.out.println(answer);
    }
    public static void DFS(int [] numbers, int target, int index, int sum) {
        if(index == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        DFS(numbers,target,index+1,sum+numbers[index]);
        DFS(numbers,target,index+1,sum-numbers[index]);
    }
}
