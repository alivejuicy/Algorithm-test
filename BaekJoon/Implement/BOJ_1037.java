import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class BOJ_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        final int NUMBER_OF_MEASURE = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int measure[] = new int[NUMBER_OF_MEASURE];
        for (int i = 0; i < NUMBER_OF_MEASURE; i++) {
            measure[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(measure);
        BigInteger answer = new BigInteger((measure[0] * measure[NUMBER_OF_MEASURE -
                1]) + "");

        bw.write(answer + "\n");

        bw.flush();
        br.close();
        bw.close();

    }

}

/*
 * import java.util.*;
 * 
 * public class BOJ_1037 {
 * public static void main(String[] args) {
 * Scanner sc = new Scanner(System.in);
 * 
 * int N = sc.nextInt();
 * int min = 1000000;
 * int max = 0;
 * for (int i = 0; i < N; i++) {
 * int x = sc.nextInt();
 * min = Math.min(x, min);
 * max = Math.max(x, max);
 * }
 * System.out.println(min * max);
 * }
 * }
 */