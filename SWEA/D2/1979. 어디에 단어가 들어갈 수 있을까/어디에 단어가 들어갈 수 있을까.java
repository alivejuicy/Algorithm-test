import java.util.*;
import java.io.*;

class Solution {
    static int[][] map;
    static int n, m;
    static boolean[][] suc;
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            suc = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    //흰색 부분 1, 검은색 부분 0
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) suc[i][j] = true;
                }
            }

            int cnt =0;
            int answer = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j<n; j++){
                    if(map[i][j] == 1) cnt++;
                    else {
                        if(cnt == m) answer++;
                        cnt = 0;
                    }
                }
                if(cnt == m) answer++;
                cnt = 0;
            }

            for(int i =0; i<n; i++){
                for(int j = 0; j<n; j++){
                    if(map[j][i] == 1) cnt++;
                    else {
                        if(cnt == m) answer++;
                        cnt =0;
                    }
                }
                if(cnt == m) answer++;
                cnt = 0;
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}