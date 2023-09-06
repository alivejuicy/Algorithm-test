import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> pq = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            pq.add(i);
        }
        int cnt = 1;
        while (pq.size()>1) {
            if (cnt % k == 0) sb.append(pq.poll()).append(", ");
            else pq.offer(pq.poll());
            cnt++;
        }
        sb.append(pq.poll());
        System.out.println("<" + sb + ">");
    }
}