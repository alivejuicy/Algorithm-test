import java.util.*;
import java.io.*;

/**
 * 몇 번째 수를 부른 후 철수가 "빙고"외치는지
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, int[]> hm = new HashMap<>();
        boolean[][] arr = new boolean[5][5];
        //빙고판 숫자와 좌표값 받기
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                hm.put(Integer.parseInt(st.nextToken()), new int[]{i, j});
            }
        }

        //사회자가 부르는 값 받아서 좌표 따기
        int cnt = 0;
        boolean flag = false;
        int answer = 0;

        for (int i = 0; i < 5; i++) {
            if(flag) {
                continue;
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(st.nextToken());
                int r = hm.get(number)[0];
                int c = hm.get(number)[1];
                arr[r][c] = true;
                cnt++; //번째 수 올리기
                if (solution(arr) >= 3) {
                    answer = cnt;
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

    private static int solution(boolean[][] arr) {
        //빙고판에 담긴 숫자를 맵에서 순서대로 확인한다.
        //해시맵으로 <빙고숫자, 좌표값> 담기
        //부르는 값 받자마자 바로 좌표를 찾을 수 있도록하기
        // 빙고 check는 5 x 5 이므로 하드코딩으로 찾아내기
        int cnt = 0;
        //행검사
        for (int i = 0; i < 5; i++) {
            if (arr[i][0] && arr[i][1] && arr[i][2] && arr[i][3] && arr[i][4]) {
                cnt++;
            }
        }
        //열검사
        for (int i = 0; i < 5; i++) {
            if (arr[0][i] && arr[1][i] && arr[2][i] && arr[3][i] && arr[4][i]) {
                cnt++;
            }
        }
        //대각검사

        if (arr[0][0] && arr[1][1] && arr[2][2] && arr[3][3] && arr[4][4]) {
            cnt++;
        }

        if(arr[0][4] && arr[1][3]&& arr[2][2] && arr[3][1] && arr[4][0]){
            cnt++;
        }

        return cnt;
    }
}