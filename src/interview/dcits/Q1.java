package interview.dcits;

import java.util.Arrays;

/**
 * 神州信息第一题
 * 数组排序，但是只允许一种操作
 * 任取数组中的一个数然后将它放置在数组的最后一个位置。
 * 问最少操作多少次可以使得数组从小到大有序
 *
 * 没写出来，没仔细思考
 *
 * 第二题是个 最大子序列的值
 */
public class Q1 {

    public static void main(String[] args) {
        Q1 s = new Q1();
        String input = "8 4 2 2 1 1 1 3 1 7";
        System.out.println(s.sort(input));
    }

    public int sort (String inData) {
        // write code here
        String[] data = inData.trim().split(" ");
        int len = data.length;
        int[] nums = new int[len];
        int[] numsSorted = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = Integer.parseInt(data[i]);
            numsSorted[i] = nums[i];
        }
        Arrays.sort(numsSorted);
        int isSorted = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == numsSorted[isSorted]) isSorted++;
        }
        return len - isSorted;
    }
}