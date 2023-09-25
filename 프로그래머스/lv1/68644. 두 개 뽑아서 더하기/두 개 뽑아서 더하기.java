import java.util.*;

class Solution {
    //서로 다른 인덱스에서 두 수 뽑고 더함
    // 만들수 있는 모든 수(순열?) 배열에 오름차순으로 담아 리턴
    public int[] solution(int[] numbers) {
        
        TreeSet<Integer> ts = new TreeSet<>();
        
        for(int i = 0; i<numbers.length; i++){
            int target = numbers[i];
            for(int j = i+1; j<numbers.length; j++){
                int plus = numbers[j];
                ts.add(target+plus);
            }
        }
        int[] answer = ts.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}