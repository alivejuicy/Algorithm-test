import java.util.*;

class Solution {
    //중앙은 노란색, 테두리 1줄은 갈색
    // brown 10, yellow 2 일때 가로 세로 크기를 리턴
    // 가로 길이는 세로길이와 같거나 세로보다 길다.
    
    //약수를 구한다. 나눠떨어지면 몫이랑 나눈 수, 제곱근
    static Set<Integer> set = new TreeSet<>();
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown+yellow;
        
        answer = isMeasure(sum, yellow);
        return answer;
    
        
    }
    private int[] isMeasure(int sum, int yellow){
        int r = 0; //가로
        int c = 0; //세로
        for(int i = 1; i <= yellow; i++){
            if(yellow % i == 0) {
                int d = yellow/i;
                r = Math.max(i, d);
                c = Math.min(i, d);
                
                if((r+2)*(c+2)==sum) {
                    
                    break;
                }
            }
        }
        return new int[]{r+2,c+2};
    }
}