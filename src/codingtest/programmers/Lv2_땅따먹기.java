package src.codingtest.programmers;

import java.util.*;

public class Lv2_땅따먹기 {
        public static void solution(int[][] land) {
            int[][] dp = land;
            for(int i=1;i<land.length;i++){
                for(int j=0; j<land[i].length; j++){
                    int prevMax = getArr(j, land[i-1]);
                    dp[i][j] = prevMax + dp[i][j];
                }
            }
            int max = Integer.MIN_VALUE;
            for(int i=0;i<4;i++){
                max = Math.max(max, dp[dp.length-1][i]);
            }
            System.out.println(max);
        }

        static int getArr(int j, int[] prevLand){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<4;i++){
                if(j == i) continue;
                else list.add(prevLand[i]);
            }
            int[] arr = new int[list.size()];
            for(int i=0;i<list.size();i++){
                arr[i] = list.get(i);
            }
            Arrays.sort(arr);
            return arr[arr.length-1];
        }
}
