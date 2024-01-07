import java.io.*;
import java.util.*;

public class Main {
    // 최소 일수 구하기 - bfs로 풀것이다.
    // 상자 가로 세로 m,n 상자 수 h가 있다, 삼증 배열을 사용한다.
    // 시간복잡도를 고려한다.
    // bfs를 돌리고 최대 일수를 찾기 위해 최댓값과 비교한다.
    // bfs를 돌린 이후에 익지 않은 토마토가 보이면 -1 반환
    // 최대 일수가 그대로 1이면 원래 다 익어있는 경우
    // 최대 일수에서 1을 뺀다. 처음 관찰한 토마토는 익어있기 때문
    static int m, n, h;
    static int[] dx = new int[]{-1, 0, 1, 0, 0, 0};
    static int[] dy = new int[]{0, 1, 0, -1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};

    static int[][][] map;
    static int ans;
    static Queue<int[]> que = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new int[h][n][m];

        for (int t = 0; t < h; t++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    map[t][i][j] = tmp;
                    if(map[t][i][j] == 1) que.offer(new int[]{t, i, j});
                    //토마토가 위치하는 좌표들 먼저 큐에 담아줌
                }
            }
        }
        ans = Integer.MIN_VALUE;
        bfs();
        System.out.println(ans);
    }

    private static void bfs() {
        while (!que.isEmpty()) {
            int[] tmpArr = que.poll();
            int th= tmpArr[0];
            int tr = tmpArr[1];
            int tc = tmpArr[2];

            for (int i = 0; i < 6; i++) {
                int nh = th + dz[i];
                int nr = tr + dx[i];
                int nc = tc + dy[i];

                if (checkRange(nh, nr, nc)) {
                    que.offer(new int[]{nh, nr, nc});
                    map[nh][nr][nc] = map[th][tr][tc] + 1;
                }
            }
        }
        for (int t = 0; t < h; t++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[t][i][j] == 0){
                        ans = -1;
                        return;
                    }
                    ans = Math.max(ans, map[t][i][j]);
                }
            }
        }
        ans -= 1; //익은 일수에서 하루 빼준다.
    }

    private static boolean checkRange(int height, int r, int c) {
        return r >= 0 && c >= 0 && height >= 0 && r < n && c < m && height < h && map[height][r][c] == 0;
    }
}