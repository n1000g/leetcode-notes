package dfs.traceback;

import java.util.*;

/**
 * 17.电话号码的字母组合
 * 回溯解法
 */
public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            List<String> output = new LetterCombinationsOfAPhoneNumber().letterCombinations(input);
            for (String o : output) {
                System.out.print(o + ",");
            }
        }
    }

    private List<String> res = new ArrayList<>();
    private static final Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    private StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        dfs(digits, 0);
        return res;
    }

    public void dfs(String digits, int len) {
        // 返回
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }
        for (char c : phoneMap.get(digits.charAt(len)).toCharArray()) {
            sb.append(c);
            dfs(digits, len + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
