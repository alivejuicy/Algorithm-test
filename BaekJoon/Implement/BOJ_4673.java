public class BOJ_4673 { // 셀프 넘버
    public static void main(String[] args) {

        int index = 10000; // 1~10000까지의 수
        boolean[] nums = new boolean[index]; // 셀프 넘버를 구분할 배열 선언

        for (int i = 0; i < nums.length; i++) {
            if (d(i + 1) < index + 1)
                nums[d(i + 1) - 1] = true; // 셀프 넘버가 아니면 true를 대입한다.
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == false)
                // nums[i]이 i+1에 해당하기 때문에 i+1 출력
                System.out.println(i + 1);
        }
    }

    static int d(int n) {

        String str = Integer.toString(n);

        for (int i = 0; i < str.length(); i++) {
            n += Integer.parseInt(str.substring(i, i + 1));
        }

        return n;
    }
}
