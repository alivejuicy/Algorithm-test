import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        //2 3 5 7 11 13 .. 
        while(n!=1){
            if(isPrime(n)) answer++;
            n--;
        }
        return answer;
    }
    public boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}