import java.util.*;
class Solution {
    //참여 선수 p, 완주 선수 c
    //완주 못한 사람 이름 return(string)
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> hm = new HashMap<>();
        Set<String> set =new HashSet<>();
        for(String s : completion){
            hm.put(s, hm.getOrDefault(s, 0)+1);
        } //완주자들 맵에 담아주고, 동명이인이면 +1 되도록
        
        String same = "";
        for(String s : participant) { 
            if(!hm.containsKey(s)) {
                answer += s;
                return answer;
            } //참여자들 중 완주자에 없으면 answer에 담음
            else {
                hm.put(s, hm.get(s)-1);
            } //완주자들은 차감
        }
        
        for(String s : hm.keySet()){
            if(hm.get(s)!=0) answer+=s;
        }
        
        return answer;
    }
}