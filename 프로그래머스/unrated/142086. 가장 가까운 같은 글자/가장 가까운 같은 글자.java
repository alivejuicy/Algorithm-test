import java.util.*;
class Solution {
    
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(hm.containsKey(c)){ //이미 있는 글자일때
                int index = hm.get(c); // 인덱스를 통해서
                int value = i - hm.get(c); //떨어진 거리 계산 하고
                answer[i] = value; //배열에 담고
                hm.put(c, index); //맵 업데이트
            }else{
                //처음 나온 글자일때
                answer[i] = -1;
            }
            hm.put(c, i);
        }
        return answer;
    }
}