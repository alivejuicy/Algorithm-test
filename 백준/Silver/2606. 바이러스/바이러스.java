import java.util.*;
import java.io.*;
class Main{
    static int n, m; //컴퓨터 개수, 연결 쌍 개수
    static int[][] map; // 네트워크 상 연결된 컴퓨터 좌표 2차원 배열
    static boolean[] visit; //방문한 컴퓨터 체크하기 위한 1차원 배열
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1]; // n+1 x n+1 초기화 -> 시작점을 1로 시작했으니 n+1로 초기화한다.
        visit = new boolean[n + 1]; // 1번부터 n번 컴퓨터의 방문 여부를 담기위한 배열 초기화

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1; //바이러스 컴퓨터 쌍의 번호를 인덱스로 해서 1 할당하기
        }
        dfs(1); //1번 컴퓨터부터 dfs 돌기
        System.out.println(cnt - 1); //1번 컴퓨터 빼주기
    }

    public static void dfs(int start) {
        visit[start] = true; //1번부터 방문처리 해주고
        cnt++; // 카운트 올리기 
        for (int i = 1; i <= n; i++) { 
            if (map[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }
}