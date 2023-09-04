import java.util.*;
import java.io.*;


/**
 * Queue의 가장 앞에 있는 문서의 중요도 확인
 * 나머지 문서 중 현재문서보다 높은 문서가 하나라도 있으면 현재 문서는 큐에 가장 뒤에 배치
 */
public class Main {
    static int n, m, t;
    static Queue<Integer> ad;
    static Queue<Integer> idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            ad = new ArrayDeque<>();
            idx = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken()); //중요도를
                ad.offer(a); //큐에 담음 1,2,3,4
                idx.offer(j); //인덱스 담음
            }

            solution();

        }

    }

    private static void solution() {
        int order = 1;
        while (!ad.isEmpty()) {

            int max = Collections.max(ad);
            int current = ad.poll();
            int index = idx.poll();

            if (current == max) {
                if (index == m) {
                    System.out.println(order);
                    break;
                }
                order++;
            } else {
                ad.offer(current);
                idx.offer(index);
            }
        }
    }
}