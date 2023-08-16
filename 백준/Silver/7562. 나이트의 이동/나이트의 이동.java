import java.io.*;
import java.util.*;

public class Main {
    static int t; //테케 변수
    static int r; // 변의 길이 -> r by r 
    static int[][] map; //체스판 2차원 배열
    static boolean[][] visit; // 방문 여부 파악 배열
    static int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1}; //나이트의 이동 반경(상하)
    static int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2}; //나이트의 이동반경 (좌우) -> 총 8방향 확인을 위해
    static int answer; 

    static int[] start; //시작 좌표 담는 배열
    static int[] end; // 끝 좌표 담는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) { //테케 만큼 돌리기 위해
            r = Integer.parseInt(br.readLine());
            map = new int[r][r];
            visit = new boolean[r][r]; // 체스판이랑 방문 배열 초기화 하고


            st = new StringTokenizer(br.readLine(), " "); // 시작점 받아서 배열에 할당
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            start = new int[]{a, b};


            st = new StringTokenizer(br.readLine(), " "); //끝점 받아서 배열에 할당
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            end = new int[]{c, d};

            //bfs 돌기 -> 시작점과 최소 거리를 계산을 위한 카운트(dist)
            System.out.println(bfs(start[0], start[1], 0));

        }
    }

    private static int bfs(int x, int y, int count) {
        visit[x][y] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y, count});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == end[0] && now[1] == end[1]) { //만약 꺼냈는데 끝점에 다다랐을 경우 카운트된 거리를 답에 넣고 리턴하기
                answer = now[2];
                break;
            }

            for (int i = 0; i < 8; i++) { //나이트 이동 방향 bfs 탐색
                int nr = now[0] + dx[i];
                int nc = now[1] + dy[i];


                if (nr < 0 || nc < 0 || nr >= r || nc >= r || visit[nr][nc]) {
                    continue;
                }

                visit[nr][nc] = true;
                q.offer(new int[]{nr, nc, now[2] + 1}); //조건에 걸리지 않으면 거리+1하면서 bfs 탐색 계속
            }
        }
        return answer;
    }
}