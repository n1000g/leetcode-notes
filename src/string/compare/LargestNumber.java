package string.compare;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrs, (o1, o2) -> (o1+o2).compareTo(o2+o1));
        StringBuilder sb = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            sb.append(numStrs[i]);
        }
        if (sb.charAt(0) == '0') return "0";
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] example = new int[] {2, 3, 40, 5, 22, 9, 0};
        System.out.println(new LargestNumber().largestNumber(example));
    }
}