import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N]; 

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr); //오름차순 정렬
        solution();
        System.out.println(answer);
    }
    private static void solution(){
        answer = Integer.MAX_VALUE;
        int end = 0;
        for(int start = 0; start<N; start++){ //시작 포인터를 포문에서 지정한다.
            while(end < N && arr[end] - arr[start] < M){
                end++; //끝 포인터는 N보다 작아야하고, 두 수 차이가 M값 이상이 될때까지 끝 포인터를 뒤로 조정한다.
            }
            
            if(end == N) break; // 끝 포인터 N이면 탐색 종료
            answer = Math.min(answer, arr[end]-arr[start]);
        }
    }
}