package string.dp;

/**
 * 300. 最长上升子序列
 */
public class LIS {

    public int lengthOfLIS(int[] nums) {
        if (nums.length < 2) return nums.length;
        int[] dp = new int[nums.length];
        // dp[i] 表示 以nums[i] 结尾的 lis length
        // dp[i] = max(1 + dp[j] if j < i and nums[i] > nums[j])
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
        int res = dp[0];
        for (int i : dp) {
            res = Math.max(res, i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] example = new int[] {-2, -1};
        System.out.println(new LIS().lengthOfLIS(example));
    }
}
