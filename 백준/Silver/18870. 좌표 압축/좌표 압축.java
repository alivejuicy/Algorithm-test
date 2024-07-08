import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int[] arr;
    static int[] sortArray;
    public static void main(String[] args) throws IOException {
        // 수직선 N개의 좌표
        // 좌표 압축하려한다. Xi
        // 각 요소가 다른 요소들 중에서 몇 번째로 큰지 나타내자.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n]; // 요소 입력받을 배열 (answer는 요소대로 순위를 반환한다.)
        sortArray = new int[n]; // 입력된 수를 정렬할 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sortArray[i] = arr[i];
        }

        Arrays.sort(sortArray); //정렬한다. 이후 중복된 값은 제거할것이다.

        List<Integer> al = new ArrayList<>();
        sb = new StringBuilder();

        al.add(sortArray[0]); //첫번째 수는 미리 넣어주고
        for(int i = 1; i<n; i++){
            if(sortArray[i] != sortArray[i-1]) al.add(sortArray[i]);
        } //중복 아닌 수만 리스트에 담는다.

        for(int i = 0; i<n; i++){
            int rank = Collections.binarySearch(al, arr[i]); //이분탐색으로 인덱스 뽑아온다.
            sb.append(rank).append(" "); //런타임 위해 sb 사용해서 담는다.
        }
        System.out.println(sb.toString());
    }
}