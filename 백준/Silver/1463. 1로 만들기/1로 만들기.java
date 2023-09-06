import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * x가 3으로 나눠떨어지면 3으로 나누고, 2로 나눠떨어지면 2로
         * 1을 뺌
         * 정수 n이 주어지면 이 세가지를 적절히 써서 1 만들것
         * 횟수는 최소값으로
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[1000002];

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; //1에서 10까지 인덱스의 해당하는 숫자 들어가고
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        System.out.println(dp[n]);
    }
}