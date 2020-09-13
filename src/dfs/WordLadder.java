package dfs;

import java.util.Arrays;
import java.util.List;

/**
 * 127. 单词接龙
 *
 * 路径 path 上，最短变化 res
 *
 *
 * 有 dfs 解，但超时
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        return 0;
    }

    private boolean transformable(String s1, String s2) {
        int dif = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) dif ++;
            if (dif > 1) return false;
        }
        return dif == 1;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        int res = new WordLadder().ladderLength(beginWord, endWord, Arrays.asList(wordList.clone()));
        System.out.println(res);
    }
}
