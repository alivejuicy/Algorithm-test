import java.util.*;
import java.io.*;

public class Main {
    static int Jmoney;
    static int Smoney;
    static int stockCntJ;
    static int stockCntS;
    static int upDay;
    static int downDay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //준현 - 살 수 있는 만큼 다 매수
        //성민 - 3일 연속 가격 상승하면 싹 다 매도, 주가가 동일하면 상승한 것이 아님
        // 3일 연속 하락하면 모두 매수, 동일하면 하락한 것 아님
        // 자산: 현금 + 1/14 주가*주식 수

        int money = Integer.parseInt(br.readLine());
        Jmoney = money;
        Smoney = money;
        stockCntJ = 0;
        stockCntS = 0;
        String[] stockArr = br.readLine().split(" ");
        upDay = 0;
        downDay = 0;
        int pointer = Integer.parseInt(stockArr[0]); //1일차

        for (int i = 1; i < stockArr.length; i++) {
            int stock = Integer.parseInt(stockArr[i]); //현재 주가

            if (check(stock)) jCalc(stock); //준현 case
            //성민 case
            dayCheck(stock, pointer); //일자 체크 먼저 하고
            sCalc(stock); //주식 계산
        }

        int jResult = Jmoney + (Integer.parseInt(stockArr[13]) * stockCntJ);
        int sResult = Smoney + (Integer.parseInt(stockArr[13]) * stockCntS);

        if(jResult > sResult) System.out.println("BNP");
        if(jResult < sResult) System.out.println("TIMING");
        if(jResult == sResult) System.out.println("SAMESAME");
    }

    private static void jCalc(int stock) {
        int jCnt = Jmoney / stock; //준현이 매수 주식 수량
        stockCntJ += jCnt;
        Jmoney -= (stock * jCnt);
    }

    private static void sCalc(int stock) {
        if (upDay == 3) { //상승 주가일 경우
            if (stockCntS != 0) {
                int cash = stockCntS * stock; // 현 주가에 맞춰서 금액 계산
                Smoney += cash; // 보유 현금에 다시 합산
            }
            upDay = 0;
            stockCntS = 0;
        }

        if (downDay == 3) { //하락 주가면
            int sCnt = Smoney / stock; // 매수
            stockCntS += sCnt; // 주식 수량 합산
            Smoney -= (stock * sCnt); //보유 현금 차감
        }
    }

    private static boolean check(int stock) { // 현재 주가보다 현금이 부족한지 확인
        return stock <= Jmoney;
    }

    private static void dayCheck(int stock, int pointer) { //33매매 매도 일수 체크
        if (stock > pointer) {
            upDay++;
            downDay = 0;
        } else if (stock < pointer) {
            downDay++;
            upDay = 0;
        } else {
            upDay = 0;
            downDay = 0;
        }
    }
}