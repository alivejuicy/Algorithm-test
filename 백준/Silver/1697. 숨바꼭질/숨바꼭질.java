import java.io.*;
import java.util.*;
class Main {

    static int n, k;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 수빈이 좌표
        k = Integer.parseInt(st.nextToken()); // 동생 좌표
        map = new int[100001]; //이동 반경 범위는 최대 값 100000만큼

        bfs(); //bfs 함수 돌리기

        System.out.println(map[k]);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n); // 큐에는 수빈이 좌표부터 담아서 시작
        while (!q.isEmpty()) { //큐 빌때까지 bfs 탐색
            int now = q.poll(); //인덱스 꺼내서
            if (now == k) return; // 현재 위치가 동생이랑 닿으면 함수 끝

            if (now - 1 >= 0 && map[now - 1] == 0) { // 인덱스가 0이상이면서 시간이 0이면
                map[now - 1] = map[now] + 1; // 현재 시간에서 +1 해준다.
                q.offer(now - 1); // 현재 좌표 -1을 큐에 넣어줌
            }
            if (now + 1 <= 100000 && map[now + 1] == 0) {
                map[now + 1] = map[now] + 1;
                q.offer(now + 1);
            }
            if (now * 2 <= 100000 && map[now * 2] == 0) {
                map[now * 2] = map[now] + 1;
                q.offer(now * 2);
            }
        }
    }
}