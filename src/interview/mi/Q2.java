package interview.mi;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 给定一个字符串, 需要去除所有之前曾经出现过的字符，只保留第一次出现的字符
 * 样例输入
 * hello, welcome to xiaomi
 * 样例输出
 * helo, wcmtxia
 */
public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(new Q2().removeRepeat(input));
    }

    private String removeRepeat(String input) {
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
