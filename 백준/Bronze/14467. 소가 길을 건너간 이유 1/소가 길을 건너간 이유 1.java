import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Map<Integer, Integer> hm = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int i =0; i<n; i++){
           st = new StringTokenizer(br.readLine());
           int num = Integer.parseInt(st.nextToken()); //소 번호
           int position = Integer.parseInt(st.nextToken()); // 소 위치

            if(!hm.containsKey(num)) {
                hm.put(num, position); //없는 소면 맵에 번호랑 위치 담고 패스
                continue;
            }
            if(hm.get(num)== position) continue; //관측했는데 위치 그대로면 패스

            hm.put(num, position); //새 위치면 맵 업데이트해주고
            answer++; // 기록 +1
        }
        System.out.println(answer);
    }
}