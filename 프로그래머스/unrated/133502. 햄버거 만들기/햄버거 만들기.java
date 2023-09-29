import java.util.*;

class Solution {
    //순서에 맞게 쌓은 햄버거를 포장, 1 2 3 1 순서로
    // 
    static Stack<Integer> stack = new Stack<>();
    public int solution(int[] ingredient) {
        int answer = 0;
        
        for(int i = 0; i < ingredient.length; i++){
            int n = ingredient[i];
            stack.push(n);
            
            if(stack.size() >= 4 && isSuccess()){
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isSuccess(){
        if(stack.get(stack.size()-4) == 1
                  && stack.get(stack.size()-3) == 2
                  && stack.get(stack.size()-2) == 3
                  && stack.get(stack.size()-1) == 1){
            
            for(int i = 0; i<4; i++){
                stack.pop();
            }
            return true;
        } 
        
        return false;
    }
}