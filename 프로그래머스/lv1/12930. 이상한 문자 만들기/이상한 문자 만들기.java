import java.util.*;
import java.io.*;
class Solution {
    /**
    한개이상 단어, 공백문자로 구분, 
    짝수 알파벳 대문자, 홀수 소문자로 치환
    **/
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("");
        int count = 0;
        for(String s1 : arr) {
            if(s1.equals(" ")) {
                answer+=" ";
                count = 0;
                continue;
            }
            answer += count%2==0?s1.toUpperCase():s1.toLowerCase();
            count++;
        }
        return answer;
    }
}