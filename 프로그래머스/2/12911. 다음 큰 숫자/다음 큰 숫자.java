import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        //n의 다음 숫자는 n보다 큼, n의 다음 큰 숫자와 n은 2진수로 변환하면 1의 개수가 같다
        //n의 다음 숫자는 가장 작은수
        //Integer.toBinaryString(int i), 
        //Integer.toOctalString(int i), 
        //Integer.toHexString(int i);
        int count = 0;
        String tn = Integer.toBinaryString(n);
        
        for(int i = 0; i<tn.length(); i++){
            if(tn.charAt(i) == '1') count++;
        }
        
        for(int i = n+1; i < 1000000; i++){
            String ti = Integer.toBinaryString(i);
            int len = ti.length();
            int cnt = 0;
            for(int j = 0; j<len; j++){
                if(ti.charAt(j)=='1') cnt++;
            }
            
            if(count == cnt){
                answer = i;
                break;
            }
        }
        return answer;
    }
}