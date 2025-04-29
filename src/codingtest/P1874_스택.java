package src.codingtest;

import java.util.Scanner;
import java.util.Stack;

// 스택으로 오름차순 수열 만들기
public class P1874_스택 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int [] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<Integer>();
        int num = 1;
        boolean no = true;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < N; i++) {
            int su = A[i];
            if(su >= num) { // 현재 배열과 stack에 있는 수가 같을 경우도 포함해야한다.
                System.out.println("su: "+ su + " num: " + num);
                while(su>=num) {
                    stack.push(num++);
                    buffer.append("+\n");
                }
                stack.pop();
                buffer.append("-\n");
            }else {
                int n = stack.pop();
                System.out.println("n: "+ n);
                if(n > su){ //만약 방금 pop 한 값이 현재 배열에 있는 수보다 클 경우. ex) 방금 최상단에 있었던 4를 pop 했는데 현재 배열이 3인 경우
                    System.out.println("NO");
                    no = false;
                    break;
                }else {
                    buffer.append("-\n");
                }
            }
        }
        if(no){ //
            System.out.println(buffer.toString());
        }
    }
}
