import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> hm = new HashMap<>();
        
        int len = tangerine.length;
        for(int i : tangerine){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        
        List<Integer> al = new ArrayList<>(hm.values());
        Collections.sort(al, Collections.reverseOrder()); //크기 내림차순 정렬
        
        int ans = 0;
        int tmp = 0; //크기 배열
        for(int i : al){
            if(i+tmp>=k){
                ans++;
                break;
            }
            tmp+=i;
            ans++;
        }
        return ans;
    }
}