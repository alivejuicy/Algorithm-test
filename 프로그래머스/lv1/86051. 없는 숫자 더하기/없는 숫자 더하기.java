import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int[] arr = new int[10];
        int answer = 0;
        
        for(int i = 0; i < numbers.length; i++){
            arr[numbers[i]]++;
        }
        
        for(int j = 0; j < arr.length; j++){
            if(arr[j] > 0) continue;
            answer += j;
        }
        
        return answer;
    }
}