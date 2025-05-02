package src.codingtest.programmers;

import java.util.*;

public class Lv1_가장많이받은선물 {
    public static void main(String[] args) {
//        String [] friends = {"muzi", "ryan", "frodo", "neo"};
//        String [] gift = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        String [] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String [] gift = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};

        Map<String, Map<String,Integer>> friendsMap = new HashMap<>(); // 친구별 주고받은 횟수
        Map<String, Integer> giftMap = new HashMap<>(); // 선물지수
        Map<String, Integer> nextPresent = new HashMap<>(); // 다음달 선물

        for (int i = 0; i < friends.length; i++) {
            friendsMap.putIfAbsent(friends[i], new HashMap<>());
            giftMap.putIfAbsent(friends[i], 0);
            nextPresent.putIfAbsent(friends[i], 0);
        }
        for (int i = 0; i < gift.length; i++) {
            StringTokenizer st = new StringTokenizer(gift[i]);
            String givenName = st.nextToken();
            String recievedName = st.nextToken();
            friendsMap.get(givenName).put(recievedName, friendsMap.get(givenName).getOrDefault(recievedName,0) + 1);
            giftMap.put(givenName, giftMap.get(givenName) + 1);
            giftMap.put(recievedName,giftMap.get(recievedName) - 1);
        }

        System.out.println(friendsMap); // {ryan={muzi=3}, muzi={frodo=2}, neo={muzi=1}, frodo={ryan=1, muzi=1}}
        System.out.println(giftMap);

        for(int i = 0 ; i < friends.length; i++){
            for(int j = 0 ; j < friends.length; j++){
                int iToJ = friendsMap.get(friends[i]).getOrDefault(friends[j], 0);
                int jToI = friendsMap.get(friends[j]).getOrDefault(friends[i], 0);
                // 본인 제외
                if (friends[i].equals(friends[j])) {
                    continue;
                }
                if(iToJ > jToI){
                    nextPresent.put(friends[i], nextPresent.get(friends[i])+1);
                }
                else if(iToJ == jToI){
                    if(giftMap.get(friends[i]) > giftMap.get(friends[j])){
                        nextPresent.put(friends[i], nextPresent.get(friends[i])+1);
                    }
                }
            }
        }
        System.out.println(nextPresent);
        int max = nextPresent.values().stream().max(Integer::compareTo).get();
        System.out.println(max);
    }
}
