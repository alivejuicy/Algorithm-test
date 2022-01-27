import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2439 {
    public static void main(String[] args) throws IOException {
        BufferedReader bn = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(bn.readLine());
        bn.close();

        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
     * public static void main(String[] args) throws IOException {
     * BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
     * int N = Integer.parseInt(bf.readLine());
     * bf.close();
     * }
     */
}
