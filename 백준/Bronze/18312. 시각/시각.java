import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에
        // K가 하나라도 포함?

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int p = 0; p < 60; p++) {
                    int a = i / 10;
                    int b = i % 10;
                    int c = j / 10;
                    int d = j % 10;
                    int e = p / 10;
                    int f = p % 10;
                    if (a == k || b == k || c == k || d == k || e == k || f == k) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}