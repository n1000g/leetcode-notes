package string.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 72. 编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数
 * @author: n8g
 * @createDate: 2020/9/6
 * @thinking:
 *      dp[i][j] 表示 word1[::i] 到 word2[::j] 的最小操作数
 *      dp[i][j] = 1. dp[i-1][j-1] && word1[i] == word2[j]
 *               = 2. min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])  && word1[i] != word2[j]
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < len2 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] inputs = line.split(" ");
            int result = new EditDistance().minDistance(inputs[0], inputs[1]);
            System.out.println(result);
        }
    }
}
