import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static long answer;
    static int[] times;
    public static void main(String[] args) throws IOException {
        // 상근이와 친구들 인원 수 M, 입국심사대 N개
        // 프로그래머스와 동일 문제
        // 복기하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        times = new int[N];
        for(int i =0; i<N; i++){
            times[i] = Integer.parseInt(br.readLine());
        }
        //시간의 최소와 최대로 이분탐색
        Arrays.sort(times);
        answer = 0;

        long start = 0;
        long end = times[N - 1] * (long)M; // 21억 이상이 될 수 있음

        while(start<=end){
            long mid = (start+end)/2; //중간 시간값
            long p = 0; //중간 시간대에서 최대 심사 완료 인원
            for(int i =0; i < N; i++){
                if(p > M) break;
                long time = times[i];
                p += (mid / times[i]);
            }
            if(p < M){ //심사를 다 못마쳤을 경우
                start = mid+1;
            }else{
                answer = mid;
                end = mid-1;
            }
        }
        System.out.println(answer);
    }
}