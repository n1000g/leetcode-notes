package string.dp;

/**
 * 300. 最长上升子序列
 */
public class LIS {

    /**
     * 最优解 O(NlogN)
     * 贪心 + 二分查找
     * 贪心思路：要使上升子序列尽可能的长，
     *         则我们需要让序列上升得尽可能慢，
     *         因此我们希望每次在上升子序列最后加上的那个数
     *         尽可能的小
     * 设计思路：维护一个数组 minVal[]
     *         min[i] 表示长度为 i 的最长上升子序列的末尾元素的最小值
     *         用 res 来表示最长递增子序列的长度
     *         对数组进行迭代, 依次判断每个数 num 将其插入 minVal 数组相应的位置
     */
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int[] minVal = new int[len];
        int res = 0;
        for (int num : nums) {
            int lo = 0, hi = res;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (minVal[mid] < num) lo = mid + 1;
                else hi = mid;
            }
            minVal[lo] = num;
            if (lo == res) res++;
        }
        return res;
    }

    // O(N^2)
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
        LIS lis = new LIS();
        System.out.println(lis.lengthOfLIS(example));
        System.out.println(lis.lengthOfLIS2(example));
    }
}
