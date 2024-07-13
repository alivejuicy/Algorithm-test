import java.io.*;
import java.util.*;

public class Main {
    static TreeMap<Integer, Integer> tm;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            int k = Integer.parseInt(br.readLine());
            tm = new TreeMap<>(); // key: 숫자데이터, value: 개수

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String order = st.nextToken();
                int numData = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {
                    tm.put(numData, tm.getOrDefault(numData, 0) + 1); //숫자 key로 잡고 개수 카운팅
                }
                if (order.equals("D")) { 
                    if (!tm.isEmpty()) { //값 있을때만 삭제하기로
                        int key = 0;
                        int value = 0;

                        if (numData == 1) {
                            key = tm.lastKey();
                        } else {
                            key = tm.firstKey();
                        }
                        value = tm.get(key);

                        if (value <= 1)
                            tm.remove(key); 
                        else
                            tm.put(key, value - 1); // 개수 줄이거나 1개면 아에 지움
                    }
                }
            }

            sb = new StringBuilder();

            if (tm.isEmpty())
                sb.append("EMPTY");
            else
                sb.append(tm.lastKey()).append(" ").append(tm.firstKey());

            System.out.println(sb.toString());
        }
    }
}