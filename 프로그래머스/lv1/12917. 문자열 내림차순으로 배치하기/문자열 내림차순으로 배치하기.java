import java.util.*;

class Solution {
    public StringBuilder solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("");
        Arrays.sort(arr, Comparator.reverseOrder());
        for(String a : arr){
            sb.append(a);
        }
        return sb;
    }
}