package nowcoder.bytedance;

/**
 * @description: 有 n 个字符串，每个字符串都是由 A-J 的大写字符构成。
 * 现在你将每个字符映射为一个 0-9 的数字，
 * 不同字符映射为不同的数字。这样每个字符串就可以看做一个整数，
 * 唯一的要求是这些整数必须是正整数且它们的字符串不能有前导零。
 * 现在问你怎样映射字符才能使得这些字符串表示的整数之和最大？
 * @author: n8g
 * @createDate: 2020/9/7
 */

import java.util.*;

// TODO: 未完成
public class MaxMap {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] weights = new int[10];
        int weight = 1;
        while (n-- != 0) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray(); //chars[0-9] <==> A-J
            for (int i = chars.length - 1; i >= 0; i--) {
                weights[chars[i] - 'A'] += weight;
                weight *= 10;
            }
            weight = 1;
        }
        Arrays.sort(weights);
        int res = 0;
        int integer = 0;
        for (int value : weights) {
            res += value * integer++;
        }
        System.out.println(res);
    }
}