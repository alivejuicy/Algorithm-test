import java.io.*;
import java.util.*;

public class Main {
    //최소 배추지렁이 마릿수를 센다.
    static int T, M, N, K;
    static int[][] mat;
    static boolean[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int index = 0; index < T; index++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            mat = new int[M][N];
            visited = new boolean[M][N];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                mat[x][y] = 1; //배추 위치 좌표에 표시를 해준다.
            }

            ans = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (mat[i][j] == 1 && !visited[i][j]) {
                        Dfs(i, j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static void Dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny] || mat[nx][ny] !=1) continue;
            Dfs(nx, ny);
        }
    }
}