import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static String[] emblem;
    static int[] power;
    static int target;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        emblem = new String[N];
        power = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            emblem[i]= st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }
        sb = new StringBuilder();
        for(int i =0; i<M; i++){
            target = Integer.parseInt(br.readLine());
            binarySearch();
        }
        System.out.println(sb.toString());

    }
    private static void binarySearch(){
        int start = 0;
        int end = N-1;
        while(start<=end){
            int mid = (start+end)/2;

            if(power[mid] < target){
                start = mid+1;
            }else{
                end = mid -1; //lower bound 고려해서 같은 값이면 맨 처음 나온 인덱스여야한다.
            }
        }
        sb.append(emblem[start]).append("\n");

    }
}