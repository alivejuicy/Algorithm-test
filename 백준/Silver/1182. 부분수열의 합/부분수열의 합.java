import java.io.*;
import java.util.*;

public class Main {
    static int n, s;
    static int counter = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int tmp = 0;
        recursion(0, tmp);
        if (s == 0) counter -= 1;
        System.out.println(counter);
    }

    private static void recursion(int start, int temp) {
        if (start == n) {
            if (temp == s) {
                counter++;
            }
            return;
        }
        //현재 원소를 선택한 경우
        recursion(start + 1, temp + arr[start]);
        //현재 원소를 선택하지 않은 경우
        recursion(start + 1, temp);
    }
}