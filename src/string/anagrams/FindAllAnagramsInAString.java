package string.anagrams;

import util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 438. 找到字符串中所有字母异位词
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * @author: n8g
 * @createDate: 2020/9/6
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        // init window
        char[] charsS = s.toCharArray();
        char[] charsP = p.toCharArray();
        int[] needs = new int[26];
        int[] windows = new int[26];
        for (char c : charsP) {
            needs[c - 'a'] ++;
        }
        int left = 0, right = 0;
        // slide window
        while (right < charsS.length) {
            // update current right character counts
            windows[charsS[right] - 'a'] ++;
            while (windows[charsS[right] - 'a'] > needs[charsS[right] - 'a']) {
                windows[charsS[left ++] - 'a'] --;
            }
            right ++;
            if (right - left == charsP.length) {
                res.add(left);
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = line;
            line = in.readLine();
            String p = line;
            List<Integer> result = new FindAllAnagramsInAString().findAnagrams(s, p);
            String out = StringUtils.integerArrayListToString(result);
            System.out.print(out);
        }
    }
}
