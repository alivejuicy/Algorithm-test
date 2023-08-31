import java.util.*;
import java.io.*;

class Solution {
    static int[] answer;
    
    public int[] solution(int[] array, int[][] commands) {
        answer = new int[commands.length];
        
        for(int i = 0; i < answer.length; i++) {
            int start = commands[i][0]; //2
            int end = commands[i][1];  //5
            int order = commands[i][2]; //3
            int[] arr = new int[end-start+1]; //4
            int index = 0;
            for(int j = start - 1; j <= end - 1; j++){
                arr[index] = array[j];
                index += 1;
            }
            Arrays.sort(arr);
            answer[i] = arr[order-1];
        }
        return answer;
    }
}