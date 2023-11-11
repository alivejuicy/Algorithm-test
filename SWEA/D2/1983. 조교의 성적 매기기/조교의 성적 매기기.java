import java.util.*;
import java.io.*;

public class Solution {
    //    학기가 끝나고, 학생들의 점수로 학점을 계산중이다.
//
//    학점은 상대평가로 주어지는데, 총 10개의 평점이 있다.
//    학점은 학생들이 응시한 중간/기말고사 점수 결과 및 과제 점수가 반영한다.
//
//    각각 아래 비율로 반영된다.
//    10 개의 평점을 총점이 높은 순서대로 부여하는데,
//    각각의 평점은 같은 비율로 부여할 수 있다.
//    예를 들어, N 명의 학생이 있을 경우 N/10 명의 학생들에게 동일한 평점을 부여할 수 있다.
//    입력으로 각각의 학생들의 중간, 기말, 과제 점수가 주어지고,
//    학점을 알고싶은 K 번째 학생의 번호가 주어졌을 때,
//    K 번째 학생의 학점을 출력하는 프로그램을 작성하라.
    static int n, k;
    static String[] grade = new String[]{"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"};
    static double[] arr;    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            //학생 수 만큼 배열 만들기
            arr = new double[n];
            //총점, 학번 담는 출석부
            for (int i = 0; i <n; i++) {
                st = new StringTokenizer(br.readLine());
                int middle = Integer.parseInt(st.nextToken());
                int last = Integer.parseInt(st.nextToken());
                int homework = Integer.parseInt(st.nextToken());
                double sum = calc(middle, last, homework);
                arr[i] = sum;
            }
            double target = arr[k-1];
            String ans = searchGrade(target);
            System.out.println("#"+t+" "+ans);
        }
    }

    private static double calc(int m, int l, int hw) {
        //학생마다 총점 계산
        //총점 계산했으면 배열에 할당
        return (m * 0.35) + (l * 0.45) + (hw * 0.2);
       
    }

    private static String searchGrade(double target) {
        int provider = n / 10;
        //학점 매겨야함
        Arrays.sort(arr);
        String tmp ="";
        
        for(int index = 0; index <n; index++){
            if(arr[index] == target){
                tmp = grade[index/provider];
                break;
            }
        }
        return tmp;
    }
}