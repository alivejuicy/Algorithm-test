import java.util.*;

class Solution {
    /**
    가장 작게 지갑을 구성, 가로 세로를 스왑해서 가능하면 채택 가능
    **/
    public int solution(int[][] sizes) {
       int answer = 0;
        
        int r = 0;
        int c = 0;
        int rMax = 0;
        int cMax = 0;
        for(int i = 0; i< sizes.length; i++){
            r = Math.max(sizes[i][0], sizes[i][1]);
            c = Math.min(sizes[i][0], sizes[i][1]);
            rMax = Math.max(rMax, r);
            cMax = Math.max(cMax, c);
            
        }
        answer = rMax * cMax;
        System.out.println(answer);
        return answer;
    }
}