import java.util.*;
import java.io.*;

/**
 * 각 문자가 연속해서 나타나는 경우
 * ccazzzzbb c a z b k i n
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = n;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            HashMap<Character, Integer> hm = new HashMap<>();

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                //해시맵에 담는 과정
                //처음 등장하는 경우
                if (!hm.containsKey(c)) {
                    hm.put(c, j);
                } else {
                    if (hm.get(c) + 1 == j) {
                        hm.put(c, j);
                    } else {
                        answer--;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
