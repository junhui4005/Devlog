package src.codingtest.programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Lv1_신고결과받기 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int [] result = new int[id_list.length];
        int k = 2;

        Map<String, Map<String,Integer>> warning = new HashMap<>();
        for (String id : id_list) {
            warning.put(id, new HashMap<>());
        }
        for (String reposts : report) {
            StringTokenizer st = new StringTokenizer(reposts, " ");
            String fistName = st.nextToken();
            String secondName = st.nextToken();

            for(String id : id_list) {
                if(id.equals(secondName)) {
                    warning.get(id).put(fistName, warning.get(id).getOrDefault(fistName,0)+1);
                }
            }
        }
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            int count = warning.get(id).size();
            if(count >= k){
               System.out.println(warning.get(id).keySet());
               for(int j = 0; j < id_list.length; j++){
                   if(warning.get(id).containsKey(id_list[j])){
                       result[j] = result[j]+1;
                   }
               }
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
