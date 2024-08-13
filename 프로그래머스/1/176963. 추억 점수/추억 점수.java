import java.util.*;

class Solution {
    Map<String, Integer> hm; // 맵 사용
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        hm = new HashMap<>();
        
       for(int i = 0; i<name.length; i++){
           hm.put(name[i], yearning[i]);
       }
       
        int score = 0;
        for(int i=0; i<photo.length; i++){
            for(int j =0; j<photo[i].length; j++){
                if(hm.containsKey(photo[i][j])){ // 맵에 있는 인물만
                    score+=hm.get(photo[i][j]); // 점수 합산해줌
                }
            }
            answer[i] = score;
            score = 0;
        }
        
        
        return answer;
    }
}