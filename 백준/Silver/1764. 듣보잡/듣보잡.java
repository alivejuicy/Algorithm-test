import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //N,M
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> tm = new TreeMap<>();

        for (int i = 0; i < n + m; i++) {
            String s = br.readLine();
            tm.put(s, tm.getOrDefault(s, 0) + 1);
        }
        for (String s : tm.keySet()) {
            if (tm.get(s) > 1) {
                cnt++;
                sb.append(s).append("\n");
            }
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

}