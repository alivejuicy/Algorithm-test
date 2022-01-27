import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//import java.util.List;

public class BOJ_5598 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String aski = bf.readLine();
        StringBuilder decode = new StringBuilder(); // 암호 해석 후 decode에 저장

        for (int i = 0; i < aski.length(); i++) {
            switch (aski.charAt(i)) {
                case 'C':
                    decode.append("Z");
                    break;
                case 'B': // 입력 받은 문자중 'C'가 있으면
                    decode.append("Y"); // 'Y'로 변환하여 추가
                    break;
                case 'A': // 입력 받은 문자중 'C'가 있으면
                    decode.append("X"); // 'Z'로 변환하여 추가
                    break;
                default: // 그 외에 경우에는
                    decode.append((char) (aski.charAt(i) - 3)); // 아스키코드를 이용하여 3만 빼줬을 때의 변환 값을 추가
            }
        }

        bw.write(decode + "\n"); 
        bw.flush();
    }
}
