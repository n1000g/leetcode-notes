package string.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 最长公共子串
 * @author: n8g
 * @createDate: 2020/9/6
 * @Thinking: 不同于最长公共子序列的是
 *            dp[i][j] = dp[i-1][j-1] && str1[i] == str2[j]
 *            dp[i][j] = 0
 */
public class LCS1 {
    public int longestCommonSubstring(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] inputs = line.trim().split(" ");
            int res = new LCS1().longestCommonSubstring(inputs[0], inputs[1]);
            System.out.println(res);
        }
    }
}
