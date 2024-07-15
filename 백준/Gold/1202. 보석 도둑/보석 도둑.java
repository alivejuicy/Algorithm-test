import java.util.*;
import java.io.*;

public class Main {
    static int N; // 보석개수
    static int K; // 가방 개수
    static int[][] present;
    static int[] bag;
    static Queue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //보석은 한 가방에 한개만 담을 수 있다.
        //가방에 수용 가능한 무게 중 가장 비싼 가격인걸 담는다. -> 최댓값
        // 최댓값의 합을 구한다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());// 보석 개수 : 5
        K = Integer.parseInt(st.nextToken()); // 가방 개수 : 2
        //보석과 가방을 정렬한다.
        present = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            present[i][0] = Integer.parseInt(st.nextToken()); //보석 무게
            present[i][1] = Integer.parseInt(st.nextToken()); //보석 가격
        }
        bag = new int[K];
        for (int i = 0; i < K; i++) { //가방별 최대 수용 무게
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag); //가방 무게 오름차순 정렬 nlogn
        Arrays.sort(present, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0]; // nlogn;
            }
        }); //보석 무게순 오름차순 정렬
        pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 가격을 봅을 거기 때문에 내림차순
        int index = 0;
        long maxPrice =0; //최댓값 범위가 int보다 높을 수 잇음

        for(int i =0; i<K; i++){
            while(N > index){ //보석 총개수만큼 반복
                if(bag[i] < present[index][0]) break; // 가방 무게보다 큰 보석이면 stop
                pq.offer(present[index][1]); //가격을 담아준다. , 최대 n번 삽입
                index++;
            }
            if(!pq.isEmpty()) maxPrice += pq.poll(); //가격 높은거 뽑아서 합산
        }

        System.out.println(maxPrice);
    }
}