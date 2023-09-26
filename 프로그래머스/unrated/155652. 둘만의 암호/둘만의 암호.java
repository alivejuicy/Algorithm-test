import java.util.*;
class Solution {
    //두 문자열 s, skip 자연수 index
    // 문자열 s의 각 알파벳 -> index 뒤 앞파벳
    static int[] arr = new int[26];
    
    public String solution(String s, String skip, int index) {
        String answer = "";
        //스킵할 부분 배열에 -1 넣어줌
        for(int i = 0 ; i< skip.length(); i++){
            int n = skip.charAt(i) - 'a';
            arr[n] = -1;
        }
        
        for(int i = 0; i < s.length(); i++){
            int n  = s.charAt(i) - 'a'; // 변
            int count = 0;
            while(count < index) {
                n++;
                 //index만큼 가면서 skip 판별
                // n++;
                if(n >= arr.length) {
                   n -= 26;
                } 
                
                if(arr[n] == -1) {
                    continue; // skip이면 패스
                }
                count++;
                
                
            }
            char c = (char)(n+'a');
            answer += String.valueOf(c);
            
        }
        return answer;
    }
}