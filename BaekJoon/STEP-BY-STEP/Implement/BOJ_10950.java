import java.util.Scanner; //A+B 입력 받은 횟수만큼 두 상수를 더해서 출력

public class BOJ_10950 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        a = sc.nextInt(); // 공백 전까지, 숫자 입력 횟수만 읽어들임

        int b; // enter 입력 전까지 받음
        int c;

        for (int i = 0; i < a; i++) {
            b = sc.nextInt();
            c = sc.nextInt();
            System.out.println(b + c);
        }
    }
}
