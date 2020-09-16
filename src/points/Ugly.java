package points;

/**
 * 264:第 n 个丑数
 *
 *      三指针
 */
public class Ugly {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int tmp2, tmp3, tmp5;
        for (int i = 1; i < n; i++) {
            // 1,2,3,4,5,6,
            tmp2 = 2 * dp[p2];  // 01 2   ...
            tmp3 = 3 * dp[p3];  // 0 1  2 ...
            tmp5 = 5 * dp[p5];  // 0   1  ...
            dp[i] = Math.min(tmp2, Math.min(tmp3, tmp5));
            if (dp[i] == tmp2) p2++;
            if (dp[i] == tmp3) p3++;
            if (dp[i] == tmp5) p5++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Ugly solution = new Ugly();
        for (int i = 1; i < 100; i += 10) {
            for (int j = i; j < i + 10; j++) {
                System.out.print(solution.nthUglyNumber(j));
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
