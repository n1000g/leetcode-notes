package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description: 1.两数之和
 * @author: n8g
 * @createDate: 2020/9/7
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        // 一遍哈希 O(n) + O(n)
        // key:     nums[i]
        // value:   i
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (map.containsKey(key)) {
                return new int[] {i, map.get(key)};
            } else {
                map.put(target - nums[i], i);
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int i = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] s_nums = line.split(" ");
            int[] nums = new int[s_nums.length];
            int i = 0;
            for (String s : s_nums) {
                nums[i++] = Integer.parseInt(s);
            }
            int target = scanner.nextInt();
            System.out.println(Arrays.toString(nums) + " t"+ target);
            System.out.println(Arrays.toString(twoSum(nums, target)));
        }
    }
}
