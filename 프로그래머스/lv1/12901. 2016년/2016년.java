import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String[] week = new String[]{"FRI","SAT","SUN","MON","TUE","WED","THU"};
        //꼼수
        int[] arr = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        
        
        int day = 0;
        for(int i =0; i<a-1; i++){
            day += arr[i];
        }
        day += b-1;
        
        String answer = week[day%7];
        
        return answer;
    }
}