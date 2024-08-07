import java.io.*;
import java.util.*;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, R;
    static char[][] domino;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0}; //상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    static int answer = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        domino = new char[N + 1][M + 1];

        for (int k = 1; k <= N; ++k) {
            Arrays.fill(domino[k], 'S'); //fill 함수 확인
        }
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (R-- > 0) {
            st = new StringTokenizer(br.readLine());
            int atkX = Integer.parseInt(st.nextToken());
            int atkY = Integer.parseInt(st.nextToken());
            int dir = getDir(st.nextToken().charAt(0));

            st = new StringTokenizer(br.readLine());
            int defX = Integer.parseInt(st.nextToken());
            int defY = Integer.parseInt(st.nextToken());

            if (domino[atkX][atkY] == 'S') {
                domino[atkX][atkY] = 'F';
                answer += attack(atkX, atkY, dir);
            }
            domino[defX][defY] = 'S'; //다시 세우기
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");

        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= M; ++j) {
                sb.append(domino[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static int attack(int x, int y, int dir) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        int count = 1;

        while (!q.isEmpty()) {
            Point p = q.poll();
            int currentH = map[p.x][p.y]; // 3

            int mx = p.x;
            int my = p.y;

            for (int t = 1; t < currentH; ++t) {
                
                mx += dx[dir];
                my += dy[dir];
                if(!(mx > 0 && my > 0 && mx <= N && my <= M)){
                    break;
                }

                if (domino[mx][my] == 'F') {
                    continue;
                }
                domino[mx][my] = 'F';
                count++;
                q.add(new Point(mx, my));
                
            }
        }
        return count;
    }

    public static int getDir(char c) {
        if (c == 'E') {
            return 3; //동 / 우
        }
        else if (c == 'W') {
            return 2; //서 / 좌
        }
        else if (c == 'S') {
            return 1; // 남 / 하
        }
        else {
            return 0; // 북 / 상
        }
    }
}
