import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 자연수 N, N의 분해합은 N+N의 자릿수
        // 자연수 M의 분해합이 N이면 M은 N의 생성자
        // 245의 분해합이 256이니까 245는 256의 생성자
        // 216의 생성자 구하기
        // 완전탐색으로 n까지 조건 걸어서 다 탐색

        int answer = 0;
        for(int i = 0; i < n; i++){
            int number = i;
            int sum = 0; // 각 자릿수 합계
            while(number != 0){ //
                sum += number % 10;
                number /= 10;
            }
            if(sum + i == n){
                //자릿수 + 생성자
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }

}