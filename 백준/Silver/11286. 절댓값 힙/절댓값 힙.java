import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                new Comparator<Integer>() { //절댓값 정렬 기준 재정의하기
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        int a = Math.abs(o1); 
                        int b = Math.abs(o2);
                        if (a == b) { // 절댓값이 같으면
                            return o1 > o2 ? 1 : -1; //절댓값 같은 수들은 기존 값으로 오름차순
                        } else { // 절댓값 다르면
                            return a - b; // 절댓값으로 오름차순
                        }
                    }
                });

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.offer(a);
            }
        }
        System.out.println(sb);
    }
}