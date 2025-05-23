package src.codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991_이진트리 {
    static int [][] btree = new int [26][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            int parentIndex = parent-'A';
            btree[parentIndex][0] = (left == '.') ? -1 : left - 'A';
            btree[parentIndex][1] = (right == '.') ? -1 : right - 'A';
        }

        preorder(0);
        System.out.println();
        inorder(0);
        System.out.println();
        postorder(0);
    }
    static void preorder(int now) {
        if(now == -1)   return;

        System.out.print((char)(now +'A'));
        preorder(btree[now][0]);
        preorder(btree[now][1]);
    }
    static void inorder(int now) {
        if(now == -1)   return;
        inorder(btree[now][0]);
        System.out.print((char)(now +'A'));
        inorder(btree[now][1]);
    }
    static void postorder(int now) {
        if(now == -1)   return;
        postorder(btree[now][0]);
        postorder(btree[now][1]);
        System.out.print((char)(now +'A'));
    }
}
