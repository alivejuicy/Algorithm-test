import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] map = new int[100001];
    static int[] dx = new int[]{-1, 1, 0};
    //    static int ans = 0;
    static Queue<Integer> que = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        //숨바꼭질 n, k
        // x * 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        que.offer(n);
        bfs();
        System.out.println(map[k]);
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            int depth = que.poll();
            if (depth == k) {
                return;
            }
            for (int i = 0; i < 3; i++) {
                int nx = depth + dx[i];
                if(i == 2) nx *=2;
                
                if (nx < 0 || nx >= map.length || map[nx] != 0) continue;
                map[nx] = map[depth] + 1;
                que.offer(nx);
            }
        }
    }
}
