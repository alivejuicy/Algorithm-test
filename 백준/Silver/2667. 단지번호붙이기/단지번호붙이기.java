import java.io.*;
import java.util.*;

class Main {
    static int n; //입력 받을 숫자 n 선언
    static int[][] map; // 입력 받은 수를 담을 matrix, 혹은 map이라 지칭하는 2차원 배열
    static boolean[][] visit; // 방문 여부를 판단하기 위한 2차원 배열
    static int[] dx = {-1, 1, 0, 0}; //방향성 배열의 x 좌표값 
    static int[] dy = {0, 0, -1, 1}; // y좌표값
    static int cnt = 0; //단지수 세는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine()); //n 입력받아서
        map = new int[n][n]; // map, visit 인덱스 초기화
        visit = new boolean[n][n]; 

        for (int i = 0; i < n; i++) { //2중 포문으로 map 채워주기
            String s = br.readLine();
            
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        } //map 배열에 01101010 ... 등의 값을 채웟음

        List<Integer> al = new ArrayList<>(); // 단지 번호를 담기위한 리스트 선언
        StringBuilder sb = new StringBuilder(); //정답 개수를 담기위한 스트링빌더

        for (int i = 0; i < n; i++) { //2중포문으로 맵 내부 돌면서
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visit[i][j]) { //맵 내부에서 값이 1(집이 있는 경우)이면서 방문을 안했으면
                    dfs(i, j); // dfs 재귀 호출 -> 다음 depth로 -> dfs함수에서는 방문이 가능한 좌표를 돌아보고 함수가 종료될것임
                    al.add(cnt); //리스트에 cnt 값 담고
                    cnt = 0; //cnt 초기화
                }
            }
        }
        sb.append(al.size()).append("\n");
        Collections.sort(al);
        for (int a : al) {
            sb.append(a).append("\n");
        }

        

        System.out.println(sb.toString());
    }

    private static void dfs(int r, int c) {
        visit[r][c] = true;
        cnt++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr < 0 || nc < 0 || nr >= n || nc >= n || map[nr][nc] == 0 || visit[nr][nc]) {
                continue;
            } //동서남북을 돌아봤는데 continue 조건에 다 걸려서 포문 종료되면 그대로 dfs 종료

            dfs(nr, nc);

        }
    }

}