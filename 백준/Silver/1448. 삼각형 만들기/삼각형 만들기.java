import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /**
         * 삼각형 조건 a+b>c (c가 제일 큰 변)
         */
//        Map<Integer, Integer> tm = new TreeMap<>();
        Integer[] arr = new Integer[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, (i1, i2) -> i2 - i1);
        for (int i = 0; i < n - 2; i++) {
            int c = arr[i];
            int a = arr[i + 1];
            int b = arr[i + 2];
            if (a + b > c) max = Math.max(max, a + b + c);
        }
        if (max == 0) System.out.println(-1);
        else System.out.println(max);
    }
}