import java.util.*;
class Solution {
    //N마리 포켓몬 중 절반 가져가도록
    // 같은 종류는 같은 번호 -> map
    // 최대한 많은 종류를 리턴
    
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < len; i++){
            if(set.size() >= len/2 ) break;
            set.add(nums[i]);
            //해쉬셋에 포켓몬 담기
            
        }
        answer = set.size();
       
        return answer;
    }
}