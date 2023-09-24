import java.util.*;
import java.io.*;

class Solution {
    //문자열의 인덱스 n번째 글자 기준 오름차순 정렬할것
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(o1.charAt(n)==o2.charAt(n)) return o1.compareTo(o2);
                else return o1.charAt(n) - o2.charAt(n);
            }
        });
        String[] answer = strings;
        return answer;
    }
}