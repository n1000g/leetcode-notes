package dfs;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 515. 在每个树行中找最大值
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 *
 */
public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(2);
        a.left = b;
        a.right = c;
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(3);
        b.left = d;
        b.right = e;
        TreeNode f = new TreeNode(9);
        c.right = f;
        List<Integer> res = new FindLargestValueInEachTreeRow().largestValues(a);
        // res 可迭代，可以直接用 foreach
        for(Integer r : res) {
            System.out.print(r);
        }
    }

    private List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private static void dfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) return;
        if (res.size() <= level)
            res.add(Integer.MIN_VALUE);
        res.set(level, Math.max(res.get(level), root.val));
        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);
    }
}
