package src.codingtest;

import java.util.Scanner;

public class Example_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String m = sc.next();
        char [] chars = m.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            sum += chars[i] ;
        }
        System.out.println(sum);
    }
}
