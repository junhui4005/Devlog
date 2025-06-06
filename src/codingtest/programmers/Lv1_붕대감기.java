package src.codingtest.programmers;

public class Lv1_붕대감기 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        answer -= attacks[0][1];
        for(int i = 0; i<attacks.length - 1; i++){
            int bf = attacks[i][0];
            int af = attacks[i+1][0];
            int bt = af - bf - 1;
            if(bt >= bandage[0]){
                answer += bandage[2]*(bt/bandage[0]) + (bandage[1]*bt);
            }else{
                answer += (bandage[1]*bt);
            }

            if(answer > health){
                answer = health;
            }

            answer -= attacks[i+1][1];
            if(answer <= 0){
                answer = -1;
                break;
            }
        }

        return answer;
    }
}
