import java.util.*;

class Solution {
    static int[] one = new int[]{1,2,3,4,5};
    static int[] two = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    static int[] three = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public int[] solution(int[] answers) {
        int[] cnt = new int[3]; // 삼총사의 맞춘 개수 배열
        for(int i = 0; i < answers.length; i++){
            int a = answers[i];
            if(a == one[i%5]) cnt[0]++;
            if(a == two[i%8]) cnt[1]++;
            if(a == three[i%10]) cnt[2]++;
        }
        
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        Set<Integer> set = new TreeSet<>();
        
        int j = 1;
        for(int a : cnt){
            if(a==max) set.add(j);
            j++;
        }
        
        int[] answer = new int[set.size()];
        answer = set.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}