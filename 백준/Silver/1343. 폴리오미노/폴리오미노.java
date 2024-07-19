import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        // AAAA, BB
        // . X로 이루어진 보드판
        // 겹침없이 X를 폴리오미노로 덮는다. .은 덮으면 안됨
        // 4개면 AAAA , 2개면 BB로 고정
        // X가 홀수면 불가함 현재 보고잇는 곳이 .이면
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        
        str = str.replaceAll("XXXX", "AAAA"); //메소드로 해결
        String ans = str.replaceAll("XX", "BB");

        if(ans.contains("X")) ans = "-1";

        System.out.println(ans);
    }

    // 노가다할 이유가 없음
    private static void funtion(){
        /*
        int cnt = 0;
        for (char c : arr) {
            if (c == '.') {
                if (cnt % 2 != 0 || arr.length ==1) {
                    System.out.println(-1);
                    return;
                } else {
                    for (int i = 0; i < cnt / 4; i++) {
                        sb.append("AAAA");
                    }
                    if (cnt % 4 != 0) {
                        sb.append("BB");
                    }
                    cnt = 0;
                    sb.append(".");
                }
            } else {
                cnt++;
            }
        }
        if(cnt == 1) {
            System.out.println(-1);
            return;
        }
        if(sb.length() == 0 || cnt != 0){
            for (int i = 0; i < cnt / 4; i++) {
                sb.append("AAAA");
            }
            if (cnt % 4 != 0) {
                sb.append("BB");
            }
        }*/
    }
}
