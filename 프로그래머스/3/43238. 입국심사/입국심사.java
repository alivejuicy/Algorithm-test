import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        long answer = 0; 
        Arrays.sort(times); // 선 정렬
        int len = times.length; 
        
        long start = 0; //기준을 0분부터 가능한 최대 시간을 범위로 잡는다.
        long end = times[len-1] * (long)n;
        
        while(start <= end){
            long midTime = (start+end)/2;
            long possible= 0;
            for(int i =0; i<len; i++){
                long time = times[i];
                possible += (midTime / time);
            }

            if(possible < n){
                start = midTime + 1;
            }else{
                answer = midTime;
                end = midTime - 1;
            }
        }
        System.out.println(answer);
        return answer;
    }
}