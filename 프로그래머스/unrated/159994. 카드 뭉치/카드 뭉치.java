import java.util.*;

class Solution {
    //두개 카드배열 단어로 goal를 만들 수 있으면 yes, 안되면 no
    //순서대로 사용해야 되고, 순서 못바꿈, 조합 못함
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        HashMap<String, Integer> hm2 = new HashMap<>();
        
        for(int i = 0; i < cards1.length; i++){
            hm.put(cards1[i], i);
        }
        for(int i = 0; i< cards2.length; i++){
            hm2.put(cards2[i], i);
        }
        int order = 0;
        int order2 = 0;
        for(int i = 0; i < goal.length; i++){
            String s = goal[i];
            if(hm.containsKey(s)){
                if(hm.get(s) == order) {
                    order++;
                    continue;
                }else {
                    answer+="No";
                    return answer;    
                }
                    
            }else if(hm2.containsKey(s)){
                 if(hm2.get(s) == order2) {
                    order2++;
                    continue;
                 }else {
                    answer+="No";
                    return answer;
                 }
            } else{
                answer+="No";
                return answer;
            }
        }
        answer += "Yes";
        return answer;
    }
}