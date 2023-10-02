import java.util.*;
class Solution {
    //소수를 만들기 (1과 자기 자신으로만 나눠지는 수-> 2,3,5,7,11)
    // static int[] arr = new int[10];
    static boolean[] visit;
    static int answer;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        answer = 0;
        visit = new boolean[numbers.length()];
        
        for(int i = 0; i< numbers.length(); i++){
            dfs(numbers, "", i+1);
        }
        
       for(int a : set){
           if(isPrime(a)) answer++;
       }
        
        return answer;
    }
    
    private void dfs(String str, String tmp, int m){
        if(m == tmp.length()){
            int n = Integer.parseInt(tmp);
            if(!set.contains(n)) set.add(n);
        }
        
        for(int i = 0; i < str.length(); i++){ // 17
            if(!visit[i]){ //1부터 방문
                visit[i] = true;
                tmp += str.charAt(i); 
                dfs(str, tmp, m);
                
                visit[i] = false;
                tmp = tmp.substring(0, tmp.length()-1);
            }
        }    
        
        
    }
    
    private boolean isPrime(int number){
        if(number < 2) return false;
        for(int i = 2; i<=Math.sqrt(number); i++){
            if(number % i == 0) return false;
        }
        return true;
    }
    
}