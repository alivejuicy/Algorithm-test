import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] mat;
    static boolean[] visited;
    static Queue<Integer> que = new ArrayDeque<>();
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());//컴퓨터 수
        m = Integer.parseInt(br.readLine());//컴퓨터의 쌍 개수
        mat = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            mat[x][y] = mat[y][x] = 1; // 컴퓨터 쌍 좌표에 1이란 숫자로 연결 표시한다.
        }
        que.offer(1); // 시작점 미리 넣어주고
        visited[1] = true;
        ans = 0;
        Bfs();
        //Dfs(1);
        System.out.println(ans);
    }

    public static void Bfs() {
        while (!que.isEmpty()) {
            int num = que.poll();
            for(int i=1; i<=n; i++){
                if(mat[num][i] == 1 && !visited[i]){
                    que.offer(i);
                    visited[i] = true;
                    ans++;
                }
            }
        }
    }

    private static void Dfs(int depth){
        visited[depth] = true;
        for(int i=1; i<= n; i++){
            if(mat[depth][i] == 1 && !visited[i]){
                ans++;
                Dfs(i);
            }
        }
    }
}