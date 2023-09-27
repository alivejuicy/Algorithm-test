import java.util.*;

class Solution {
    //글자 x와 x가 아닌 글자를 센다.
    // 두 횟수가 같아지면 멈추고 분리
    public int solution(String s) {
        int answer = 0;
        
        while(s.length()!=0) {
            int cnt = 1;
            int another = 0;
            char c = s.charAt(0);
            for(int i = 1; i<s.length(); i++){
                if(c == s.charAt(i)) cnt++;
                else another++;
                
                if(cnt == another) break;
            }
            s = s.substring(cnt+another);
            answer++;
        }
     
        return answer;
    }
}