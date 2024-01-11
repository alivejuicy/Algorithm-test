import java.util.*;
import java.io.*;

public class Main {
    static int n, max;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int ans;

    public static void main(String[] args) throws IOException {
        //dfs로 맵을 돌면서 높이 1부터 100까지 탐색하는데
        // 높이보다 높은 곳일 경우 쭉 dfs
        // 탐색 마치면 영역 개수 +1
        // 해당 높이 개수 등록
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n][n];
        max = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                max = Math.max(max, num); //최대 높이 담아주기
                map[i][j] = num;
            }
        }

        int depth = 0;
//        ArrayList<Integer> al = new ArrayList<>();
        ans = 0;

        while (depth <= max) {
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > depth && !visit[i][j]) {
                        dfs(i, j, depth);
                        tmp++;
                    }
                }
            }
//            al.add(ans);
            ans = Math.max(ans, tmp);
            visit = new boolean[n][n];
            depth++;
        }

//        ans = Collections.max(al);
        System.out.println(ans);
    }

    private static void dfs(int r, int c, int depth) {
        visit[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (nr < 0 || nc < 0 || nr >= n || nc >= n || visit[nr][nc] || map[nr][nc] <= depth) continue;

            dfs(nr, nc, depth);
        }
    }
}