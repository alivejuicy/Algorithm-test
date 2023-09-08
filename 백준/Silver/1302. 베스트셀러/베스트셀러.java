import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> hm = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }
        int max = 0;
        for (String s : hm.keySet()) {
            if (hm.get(s) >= max) {
                max = hm.get(s);
            }
        }
        TreeSet<String> set = new TreeSet<>();
        for (String s : hm.keySet()) {
            if (hm.get(s) == max) {
                set.add(s);
            }
        }
        System.out.println(set.pollFirst());
    }
}