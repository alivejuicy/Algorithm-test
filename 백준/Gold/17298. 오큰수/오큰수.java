import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<k; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int i : solution(arr,k)){
            sb.append(i).append(' ');
        }
        System.out.println(sb);

//        int k = 4;
//        int[] arr = new int[]{9, 5, 4, 8};
//        int[] answer = solution(arr,k);
//        StringBuilder sb = new StringBuilder();
//        for(int i : answer){
//            sb.append(i).append(' ');
//        }
//        System.out.println(sb);
    }

    private static int[] solution(int[] arr, int k) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            //현재 원소가 스택의 맨위 인덱스가 가리키는 원소보다 큰 경우?
            //
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) { //
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
            // 3 들어가고 0 push
            // i=1 - 5부터 보면 3 < 5 이므로 arr[0] = arr[1], index 0 pop index 1 push
            // i=2 - 2보면 성립 안되니까 index 2 push
            // i=3 - 7보면 2<7 이므로  arr[2] = arr[3], index 2 pop
            // index 1 pop  arr[1] = arr[3]
            // index 3 push
        }
        while(!stack.isEmpty()){
            arr[stack.pop()] = -1; // arr[3] = -1
        }

        return arr;
    }
}