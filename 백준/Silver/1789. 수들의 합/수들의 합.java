import java.io.*;

public class Main {
    static long S;
    static long answer;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S=Long.parseLong(br.readLine());
        solution(1,S);
        System.out.println(answer);
    }
     //이분탐색
    // 정렬된 데이터에서 중간값을 잡고 타겟과 대소(왼/오)를 비교하여 탐색범위를 좁히며 탐색한다. logN
    private static void solution(long start, long end){
        if (start > end){
            return;
        }

        long mid = (start + end) / 2;
        // 중간값의 자연수 합계
        long sum = calc(mid);

        if(sum < S){
            answer = Math.max(answer, mid);
            solution(mid+1, end);
        }else if(sum > S){
            solution(start, mid-1);
        }else{
            answer = mid;
            return;
        }
    }
    private static long calc(long num){
        return (num*(num+1))/2;
    }
}