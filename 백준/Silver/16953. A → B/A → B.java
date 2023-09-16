import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); //2
        int b = Integer.parseInt(st.nextToken()); //162
        int count = 1;

        while (a != b) {
            if (a > b) {
                System.out.println("-1");
                return;
            }
            if (b % 2 == 0) {
                b /= 2;

            } else if (b % 10 == 1) {
                b /= 10;

            } else {
                System.out.println("-1");
                return;
            }
            count++;
        }
        System.out.println(count);
    }
}