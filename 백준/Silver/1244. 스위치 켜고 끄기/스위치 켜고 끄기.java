import java.util.*;
import java.io.*;

// 스위치
//
public class Main {
    static boolean[] lampArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 스위치 개수
        int lamp = Integer.parseInt(br.readLine());
        lampArr = new boolean[lamp + 1];
        st = new StringTokenizer(br.readLine());
        // 스위치 상태
        for (int i = 1; i < lampArr.length; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            boolean b = (tmp != 0); // 켜져있는지 꺼져있는지 여부
            lampArr[i] = b;
        }
        // 학생 수
        int student = Integer.parseInt(br.readLine());
        // 성별, 받은 수
        for (int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int sNum = Integer.parseInt(st.nextToken());
            lighting(gender, sNum);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < lampArr.length; i++) {
            int a = (lampArr[i]) ? 1 : 0;
            if (i % 20 == 0) {
                sb.append(a).append("\n");
                continue;
            }
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }

    private static void lighting(int g, int n) {
        //성별 판별해서
        //불 키고 끄는 로직 수행
        if (gender_case(g)) {
            calc(n);
        } else {
            fCalc(n);
        }
    }

    private static boolean gender_case(int g) {
        return g == 1;
    }

    private static void calc(int n) {
        //남학생은 스위치 번호가 자기가 받은 수의 배수이면, 그 스위치의 상태를 바꾼다
        for (int i = n; i < lampArr.length; i++) {
            if (i % n != 0) continue;
            lampArr[i] = !lampArr[i];
        }
    }

    private static void fCalc(int n) {
        int start = n - 1;
        int end = n + 1;
        while (start >= 1 && end < lampArr.length) {
            if (lampArr[start] != lampArr[end]) break;
            start--;
            end++;
        }
        start++;
        end--;
        for (int i = start; i <= end; i++) {
            lampArr[i] = !lampArr[i];
        }
    }
}