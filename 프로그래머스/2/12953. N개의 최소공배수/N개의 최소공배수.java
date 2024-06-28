import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        //최소공배수는 두수의 곱에 최대공약수를 뺀다.
        
        for(int i =0; i<arr.length - 1; i++){
            
            arr[i+1] = (arr[i] * arr[i+1]) / gcd(arr[i+1], arr[i]);
            
        }
        
        answer = arr[arr.length-1];
        return answer;
    }
    private int gcd(int n, int m){
        if(m == 0 ){
            return n;
        }else{
            return gcd(m, n % m);
        }
    }
}