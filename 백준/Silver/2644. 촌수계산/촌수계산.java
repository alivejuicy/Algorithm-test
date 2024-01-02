import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int a, b;
    static int[][] map;
    static int[] dist;
    static Queue<Integer> que = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //bfs 돌려서 두 좌표의 관계를 확인한다.
        //촌수 배열에 담긴 촌수를 리턴한다.
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];
        dist = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1; //촌수 표시
        }

        que.offer(a);
//        bfs();
        dfs(a);
        System.out.println(dist[b]==0?-1:dist[b]);
    }
    private static void dfs(int index){
        if(index == b) return;
        for(int i = 1; i<=n; i++){
            if(map[index][i] == 1 && dist[i] == 0){
                dist[i] += dist[index]+1;
                dfs(i);
            }
        }
    }
    private static void bfs() {
        while (!que.isEmpty()) {
            int tmp = que.poll();
            if(tmp == b) break;

            for(int i = 1; i<=n; i++){
                if(map[tmp][i] == 0 && dist[i] != 0) continue;
                que.offer(i);
                dist[i] += dist[tmp]+1;
            }
        }
    }
}