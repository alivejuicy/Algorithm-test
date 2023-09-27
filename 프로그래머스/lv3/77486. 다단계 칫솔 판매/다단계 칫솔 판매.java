import java.util.*;
//이익 10%는 추천인에게 배분 후 나머지는 자신이 가짐
//피라미드 구조로 추천시킨 모든 아이들의 이익 10%들을 챙길 수 있음
//
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {   
        //enroll은 직원
        //referral은 선임(윗관계)
        //seller 판매한 직원
        //amount 수량
        int eLen = enroll.length;
        int rLen = referral.length;
        Map<String, String> hm = new HashMap<>();
        Map<String, Integer> im = new HashMap<>();
        
        int[] answer = new int[eLen];
        
        int i = 0;
        for(String s : enroll) { //윗관계 맵, 직원들 총액 맵 채워놓고
            hm.put(s, referral[i]);
            im.put(s, 0);
            i++;
        } 
        //길이 8
        
        for(int j = 0; j < seller.length; j++){
                String down = seller[j]; //판매한 직원
                
                // int dIndex = im.get(down); //판매원 인덱스
                // int tIndex = im.get(top); // 윗분 인덱스
                
                int am = amount[j] * 100; //판매액 1200원
                int margin = am / 10; //10% 떼먹기 120원
                int cash = am - margin; //차액
            
                
                    im.put(down, im.get(down)+cash); //1080원
                    
                    while(!hm.get(down).equals("-")){ //윗 사람이 없을때까지
                        down = hm.get(down); // 윗사람을 가져온다.
                        if(am == 0) break;
                        else{
                            am /= 10; // 120원
                            margin = am/10; //12원
                            cash = am- margin; //108원
                            im.put(down, im.get(down)+cash);
                        }
                    }
                 
             }
        int num = 0;
        for(String s: enroll){
            answer[num++] = im.get(s);
        }

        return answer;
    }
}