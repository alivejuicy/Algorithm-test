import java.util.*;
import java.io.*;

class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[n][2]; // 이차원 배열 생성

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); // 토크나이저로 회의 시간 받기
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()); //2차원 배열에 넣기
            }
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) { // 끝 시간 같을 경우 1 4 , 3 4
                    return o1[0] - o2[0]; // 시작 시간으로 정렬
                } else {
                    return o1[1] - o2[1]; // 끝 시간 오름차순 정렬
                }

            }
        });
        // 끝 시간 오름차순 정렬한다.
        // 끝 시간 같으면 시작 시간으로 오름차순 정렬한다.

        int answer = 0; // 최대 회의 개수(정답) 변수
        int count = 1; //정렬된 첫 번째 회의를 포함한다.
        int end = arr[0][1]; //끝 시간 변수
        
           for (int j = 1; j < n; j++) { 
               if (arr[j][0] >= end) { // 회의 시작 시간이 끝 시간과 같거나 뒤일 때만
                   count++; //개수 세서
                   end = arr[j][1]; // 해당 회의 끝 시간으로 변수 업데이트
                }
            }
        answer = count;
        System.out.println(answer);
    }
}