package string.dfs;

import java.util.Scanner;

/**
 * 22. 生成括号
 *                                       (
 *                      ()                            ((
 *                      ()(                   (((            (()
 *                ()((     ()()               ((()       (()(    (())
 *                ()(()    ()()(              ((())      (()()   (())(
 *                ()(())   ()()()             ((()))     (()())  (())()
 *
 *     不返回 List 直接输出
 */
public class GenerateParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            dfs(n, n, "");
        }
    }

    private static void dfs(int leftRemained, int rightRemained, String cur) {
        // 出口
        if (leftRemained == 0 && rightRemained == 0) System.out.println(cur);
        if (leftRemained > 0)
            dfs(leftRemained - 1, rightRemained, cur + "(");
        if (rightRemained > leftRemained)
            dfs(leftRemained, rightRemained - 1, cur + ")");
    }
}
