package toclassfy;

import util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 *      给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径
 *
 *           1
 *          / \
 *         3   0
 *        / \   \
 *       5   3   8
 *
 *       9
 */
public class Solution113 {

    public static void main(String[] args) {
        Solution113 solution = new Solution113();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(0);
        a.left = b;
        a.right = c;
        TreeNode d = new TreeNode(5);
        TreeNode e = new TreeNode(3);
        b.left = d;
        b.right = e;
        c.right = new TreeNode(8);
        List<List<Integer>> res = solution.pathSum(a, 9);
        System.out.println(res.toString());
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode node, int sum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) return;
        path.add(node.val);
        // 出口：叶子节点 && 需要的 sum 等于当前叶子节点 node 的值
        if (node.left == null && node.right == null && sum == node.val) {
            res.add(new ArrayList<>(path));
        }
        dfs(node.left, sum - node.val, path, res);
        dfs(node.right, sum - node.val, path, res);
        path.remove(path.size() - 1);
    }

}
