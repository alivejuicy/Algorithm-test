import java.util.*;
import java.io.*;

public class Main {
    static int answer;
    static int[] arr;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n보다 작거나 같아야함
//        집합 k의 원소로만 구성된 가장 큰수(K는 1부터 9까지)

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[k];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        answer = 0;
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth > n) return; //현재 수가 n보다 크면 끝
        if (answer < depth) answer = depth;// 답보다 현재 수가 크면 답 업데이트
        for (int i = k - 1; i >= 0; i--) {
            dfs(depth * 10 + arr[i]);
        }
    }
}
