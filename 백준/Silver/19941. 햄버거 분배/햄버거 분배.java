import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] arr = br.readLine().split("");
        int answer = solution(arr, k);
        System.out.println(answer);
    }

    private static int solution(String[] arr, int k) {
        int tmp = 0;

        for (int i = arr.length - 1; i > -1; i--) {
            String str = arr[i];
            if (str.equals("P")) {
                int start = i+k;
                int end = i-k;
                if(start >= arr.length) start = arr.length-1;
                if(end < 0) end = 0;

                for (int j = start; j >= end; j--) {
                    if (arr[j].equals("H")) {
                        tmp++;
                        arr[j] ="X";
                        break;
                    }
                }
            }
        }
        return tmp;
    }
}