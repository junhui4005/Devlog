package src.codingtest;

import java.util.Scanner;

//
public class Example_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int [] b = new int[a];
       for (int i = 0; i < a; i++) {
           b[i] = sc.nextInt();
       }
       long sum = 0;
       long max = 0;

       for (int i = 0; i < a; i++) {
           if(b[i] > max) max = b[i];
           sum += b[i];
       }
       System.out.println(sum*100/max/a);


    }
}
