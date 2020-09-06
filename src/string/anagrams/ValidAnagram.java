package string.anagrams;

import util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @author: n8g
 * @createDate: 2020/9/6
 */
public class ValidAnagram {
    // O(max(m, n))
    public boolean isAnagram(String s, String t) {
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        for (char c : s.toCharArray()) {
            sCounts[c - 'a'] ++;
        }
        for (char c : t.toCharArray()) {
            tCounts[c - 'a'] ++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] != tCounts[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            String[] inputs = line.split(" ");
            Boolean result = new ValidAnagram().isAnagram(inputs[0], inputs[1]);
            System.out.println(result.toString());
        }
    }
}
