import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static long[] arr;
    static int ans;
    static long target;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr= new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        //input 값이 2^31 - long으로 자료형 확장해서 받기
        for(int i =0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);// 정렬 해주고
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            target = Long.parseLong(st.nextToken());
            binarySearch(0, arr.length-1); // 입력받는 타켓마다 이분탐색, 배열 인덱스 시작,끝 만큼 
            System.out.println(ans);
        }
    }
    private static void binarySearch(int start, int end){
        if(start > end){
            ans = 0;
            return;
        }

        int mid = (start+end)/2;
        if(arr[mid] < target){
            binarySearch(mid+1, end);
        }else if(arr[mid]>target){
            binarySearch(start, mid-1);
        }else{
            ans = 1;
            return;
        }
    }
}