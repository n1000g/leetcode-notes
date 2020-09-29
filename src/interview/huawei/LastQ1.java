package interview.huawei;

import java.util.Scanner;

/**
 * 17 年研发
 * 三个空汽水瓶可以换一瓶汽水
 */
public class LastQ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (n != 0) System.out.println(exchange(n));
            else break;
        }
    }

    private static int exchange(int bottle) {
        int res = 0;
        while (bottle > 2) {
            res += bottle/3;
            bottle = bottle / 3 + bottle % 3;
        }
        if (bottle == 2) res ++;
        return res;
    }


}
