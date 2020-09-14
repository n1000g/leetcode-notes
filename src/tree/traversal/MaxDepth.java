package tree.traversal;

import util.StringUtils;
import util.TreeNode;

import java.util.Scanner;

/**
 * 最大深度
 * @TestData:
 *      1,2,3,null,4,null,5,null,null,6,7,null,null,null,8
 *
 *                            1
 *                          /  \
 *                         2    3
 *                         \     \
 *                          4     5
 *                               / \
 *                              6   7
 *                                   \
 *                                    8
 *
 *                                    5
 */
public class MaxDepth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 1,2,3,null,4,null,5,null,null,6,7,null,null,null,8
            String binaryTreeString = sc.nextLine();
            TreeNode root = StringUtils.stringToBinaryTree(binaryTreeString);
            int depth = new MaxDepth().depth(root);
            System.out.println(depth);
        }
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
