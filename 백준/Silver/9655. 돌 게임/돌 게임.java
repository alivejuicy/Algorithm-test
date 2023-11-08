import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(br.readLine());
        solution(n);
    }
    private static void solution(int n){
        // n = 1이면 상근 승
        // n = 2면 창영 승
        // n = 3면 상근 승
        // n = 4면  창영 승
        // n =5면 상근 승?
        //n =6 창영 승
        // n = 7 상근  승 ..

        if(n % 2 == 0) System.out.println("CY");
        else System.out.println("SK");
    }
}
