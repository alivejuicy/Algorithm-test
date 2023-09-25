import java.util.*;
class Solution {
    // 1점부터 k점
    // m개씩 담아야됨
    
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score); //점수 오름차순으로 선 정렬
        
        
        int tmp = 0;
        //담을 수 있는 상자 개수만큼 반복
        for(int i = 0; i < score.length / m; i++){
            //상자에 담기지 않는 최소들은 버리기 위해 인덱스 잡아줌
            int index = score.length % m + tmp;    
            answer+= score[index]*m; //담아서 최대 이익 구해서 answer에 합산
            
            //과일 개수만큼 인덱스 업뎃
            tmp += m;
        }
        return answer;
    }
}