package toclassfy;

import java.util.*;

/**
 * 51. N 皇后
 *
 * 输入：4
 * 输出：[
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 */
public class Solution51 {

    private Set<Integer> col = new HashSet<Integer>();
    private Set<Integer> diag1 = new HashSet<Integer>();
    private Set<Integer> diag2 = new HashSet<Integer>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res,new ArrayList<String>(), 0, n);
        return res;
    }
    private void dfs(List<List<String>> res, List<String> list, int row, int n){
        if (row == n){
            res.add(new ArrayList<String>(list));
            return;
        }
        for (int i = 0; i < n; i++){
            // 用 HashSet 判断能否放置
            if (col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;

            // 构造结果字符串
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[i] = 'Q';
            String rowString = new String(charArray);

            // 标记
            list.add(rowString);
            col.add(i);
            diag1.add(row + i);
            diag2.add(row - i);

            // dfs
            dfs(res, list, row + 1, n);

            // 回溯
            list.remove(list.size() - 1);
            col.remove(i);
            diag1.remove(row + i);
            diag2.remove(row - i);
        }
    }

    public static void main(String[] args) {
        Solution51 solution = new Solution51();
        List<List<String>> res = solution.solveNQueens(8);
        for (List<String> r : res) {
            for (String s : r) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}