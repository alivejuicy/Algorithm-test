import java.util.*;
import java.io.*;

public class Main {
    static char[][] candy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        candy = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                candy[i][j] = s.charAt(j);
            }
        }

        /**
         * 행 바꾸고 행 검사, 열 검사, 행 다시 원래대로
         * 열 바꾸고 열 검사, 행 검사, 열 다시 원래대로
         */
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                //행을 바꿈
                char temp = candy[i][j];
                candy[i][j] = candy[i][j + 1];
                candy[i][j + 1] = temp;

                //행 검사
                for (int k = 0; k < n; k++) { //행 검사를 하는데
                    int count = 1;
                    for (int l = 0; l < n - 1; l++) {
                        if (candy[k][l] == candy[k][l + 1]) {
                            count++;
                        } else {
                            answer = Math.max(answer, count);
                            count = 1;
                        }
                    }
                    answer = Math.max(answer, count);
                }
                //열 검사
                for (int k = 0; k < n; k++) { //열 검사를 하는데
                    int count = 1;
                    for (int l = 0; l < n - 1; l++) {
                        if (candy[l][k] == candy[l + 1][k]) {
                            count++;
                        } else {
                            answer = Math.max(answer, count);
                            count = 1;
                        }
                    }
                    answer = Math.max(answer, count);
                }
                //다시 돌리기
                temp = candy[i][j];
                candy[i][j] = candy[i][j + 1];
                candy[i][j + 1] = temp;

                //열 바꾸기
                temp = candy[j][i];
                candy[j][i] = candy[j + 1][i];
                candy[j + 1][i] = temp;

                // 행 검사
                for (int k = 0; k < n; k++) { //행 검사를 하는데
                    int count = 1;
                    for (int l = 0; l < n - 1; l++) {
                        if (candy[k][l] == candy[k][l + 1]) {
                            count++;
                        } else {
                            answer = Math.max(answer, count);
                            count = 1;
                        }
                    }
                    answer = Math.max(answer, count);
                }
                //열 검사
                for (int k = 0; k < n; k++) { //열 검사를 하는데
                    int count = 1;
                    for (int l = 0; l < n - 1; l++) {
                        if (candy[l][k] == candy[l + 1][k]) {
                            count++;
                        } else {
                            answer = Math.max(answer, count);
                            count = 1;
                        }
                    }
                    answer = Math.max(answer, count);
                }
                // 다시 돌리기
                temp = candy[j][i];
                candy[j][i] = candy[j + 1][i];
                candy[j + 1][i] = temp;
            }
        }
        System.out.println(answer);
    }
}
