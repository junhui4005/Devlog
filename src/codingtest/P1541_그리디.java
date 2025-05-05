package src.codingtest;

import java.util.Scanner;

public class P1541_그리디 {
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String [] str = example.split("-");
        for(int i = 0 ; i < str.length ; i++){
            int temp = mySum(str[i]);
            if(i == 0){
                answer = answer + temp;
            }else answer = answer - temp;
        }
        System.out.println(answer);
    }
    private static int mySum(String str){
        int sum = 0;
        String [] str2 = str.split("[+]");
        for(int i = 0 ; i < str2.length ; i++){
            sum += Integer.parseInt(str2[i]);
        }
        return sum;
    }
}
