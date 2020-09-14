package merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀
 * @author: n8g
 * @createDate: 2020/9/6
 */
public class LongestCommonPrefix {

    // flower flow flash fun
    // f
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    public String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) return strs[start];
        int mid = (start + end) / 2;
        String left = longestCommonPrefix(strs, start, mid);
        String right = longestCommonPrefix(strs, mid + 1, end);
        return longestCommonPrefix(left, right);
    }

    public String longestCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index))
            index ++;
        return str1.substring(0, index);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] strs = line.trim().split(" ");
            String res = new LongestCommonPrefix().longestCommonPrefix(strs);
            System.out.println(res);
        }
    }
}
