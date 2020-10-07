package toclassfy;

import java.util.HashMap;
import java.util.Map;

/**
 * 128. 最长连续序列
 *      要求算法的时间复杂度为 O(n)。
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Solution128 {
    /**
     *      100  4   200 1   3   2
     * l    01  01  01  01  02  14
     * r    01  01  01  01  12  24
     */
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);

                int cur_length = right + left + 1;

                if (cur_length > res) res = cur_length;

                map.put(num, cur_length);
                map.put(num - left, cur_length);
                map.put(num + right, cur_length);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution128 solution = new Solution128();
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(arr));
    }
}