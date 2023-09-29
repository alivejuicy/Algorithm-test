import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        
       for(int i = 1; i< food.length; i++){
           int n = food[i] / 2; // 3개를 반으로해서 1개
           for(int j = 0; j<n; j++){
               sb.append(i); //1 들어감
           }
       }
       answer+=sb.toString()+"0";
       answer+=sb.reverse().toString();
        
        return answer;
    }
}