import java.util.*;

class Solution {
    //1부터 45숫자 중 6개
    //당첨 최고 등수, 최저 등수를 리턴
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(lottos); //로또 선정렬
        Map<Integer, Integer> tm = new TreeMap<>(); 
        
        int j = 0;
        int zero = 0; 
        
        for(int a : win_nums){ // 1 6 10 19 31 45
            tm.put(a, 0); //당첨 번호 맵에 담고
            if(lottos[j]==0) zero++; //훼손된 로또 개수 세기
            j++;
        }
        
        int basic = 0;
        for(int i =0; i<lottos.length; i++){
            int n = lottos[i];
            if(tm.containsKey(n)) { //당첨 번호면
                tm.remove(n); //지우고
                basic++; //당첨 개수 세기
            }
        }
        int min = lottos.length - basic; //최소 등수
        int max = min - zero; //최대 등수
        answer[1] = min>=6?6:min+1; 
        answer[0] = max>=6?6:max+1;
        //배열 초기화
        return answer;
    }
}