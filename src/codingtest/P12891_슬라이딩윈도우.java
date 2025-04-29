package src.codingtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 슬라이딩 윈도우
public class P12891_슬라이딩윈도우 {

    static int [] checkArr ;
    static int [] myArr;
    static int checkSecret;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int Result = 0;
        myArr = new int[4];
        checkArr = new int[4];
        checkSecret = 0;
        char [] c = new char[a];

        c = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine()); // ex) CCTGGATTG
        for(int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0){ // 0일 경우 이미 조건 만족함
                checkSecret++;
            }
        }

        for(int i = 0; i < b; i++) { // 맨처음 체크 할 문자열
            Add(c[i]);
        }

        if (checkSecret == 4) {
            Result++;
        }

        for(int i = b; i < a; i++) {
            int j  = i - b;
            Add(c[i]);
            Remove(c[j]);
            if(checkSecret == 4) {
                Result ++;
            }
        }
        System.out.println(Result);
        br.close();
    }
    private static void Add(char C){
        switch(C){
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0]){
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1]){
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2]){
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3]){
                    checkSecret++;
                }
                break;
        }
    }

    private static void Remove(char C){
        switch(C){
            case 'A':
                if(myArr[0] == checkArr[0]){
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if(myArr[1] == checkArr[1]){
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if(myArr[2] == checkArr[2]){
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if(myArr[3] == checkArr[3]){
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }
}
