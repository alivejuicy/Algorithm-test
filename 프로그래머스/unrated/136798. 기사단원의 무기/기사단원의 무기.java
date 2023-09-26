import java.util.*;

class Solution {
    //1부터 n까지
    //기사수 n, 제한수치 l, 공격력 p
    //**시간초과 해결하기
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] arr = new int[number]; //배열 파서
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = isPrime(i+1); //1부터 n까지 약수 개수를 판별한다. 
            
            if(arr[i] > limit) arr[i] = power; // 리밋보다 크면 파워로 업뎃
            
            answer += arr[i];
        }
        return answer;
    }
    private int isPrime(int n){
        int cnt = 0;
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(i * i == n) cnt += 1; //제곱근이면 +1
            
            else if(n % i == 0) cnt += 2; //몫도 약수로 취급하기에 +2
            
        }
        return cnt;
    }
}