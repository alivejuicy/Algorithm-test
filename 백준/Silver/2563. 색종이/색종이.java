import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 색종이 수
        arr = new int[101][101]; //색종이 담을 행렬 생성

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            make(r, c);
        }

        int answer = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (arr[i][j] == 1) answer++;
            }
        }

        System.out.println(answer);

    }

    static void make(int r, int c) {
        for (int i = r; i < r + 10; i++) {
            for (int j = c; j < c + 10; j++) {
                arr[i][j] = 1;
            }
        }
    }
}