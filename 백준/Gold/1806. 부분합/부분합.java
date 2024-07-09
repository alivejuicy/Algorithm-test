import java.util.*;
import java.io.*;
public class Main {
    static int N;
    static int S;
    static int[] arr;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //Arrays.sort(arr); 정렬할 이유가 없음, 값의 최솟값이 아니라 길이의 최소값을 구하는 것이라 할 이유가 없었다.
        solution();
        System.out.println(ans);
    }
    //최소 길이를 구하는 투포인터 문제.
    private static void solution(){
        ans = Integer.MAX_VALUE;
        int len = 0;
        int end = 0;
        int psum = arr[0];

        for(int start=0; start<N; start++){
            while(end < N && psum < S){
                end++;
                if(end != N) psum+=arr[end];// 뒷 포인터 값을 더하며 누적한다.
            }
            if(end == N) break;

            len = end-start;
            ans = Math.min(ans, len+1);//인덱스라 구간의 길이는 +1 해준다.
            psum -= arr[start]; // 앞 포인터의 값을 빼나가며 누적한다.
        }
        if(ans == Integer.MAX_VALUE) ans = 0;
    }
}