package tree.traversal;

import util.TreeNode;
import util.StringUtils;

import java.util.*;

/**
 * @description: 迭代
 * @author: n8g
 * @createDate: 2020/9/9
 *
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
 */
public class BTreeTraversal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 1,2,3,null,4,null,5,null,null,6,7,null,null,null,8
            String binaryTreeString = sc.nextLine();
            TreeNode root = StringUtils.stringToBinaryTree(binaryTreeString);
            BTreeTraversal solution = new BTreeTraversal();
            List<Integer> preorder = solution.preorderTraversal(root);
            System.out.println("ProOrder: " + preorder.toString());
            List<Integer> inorder = solution.inorderTraversal(root);
            System.out.println("InOrder: " + inorder.toString());
            List<Integer> postorder = solution.postorderTraversal(root);
            System.out.println("PostOrder" + postorder.toString());;
            List<Integer> levelorder = solution.levelorderTraversal(root);
            System.out.println("LevelOrder" + levelorder.toString());
        }
    }

    /**
     * 先序遍历
     *      中左右
     */
    private List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.push(root);
        //化简后的先序遍历
        //while (!stack.isEmpty()) {
        //    TreeNode node = stack.pop();
        //    if (node != null) {
        //        res.add(node.val);
        //        if (node.right != null) stack.push(node.right);
        //        if (node.left != null) stack.push(node.left);
        //    }
        //}
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
                stack.push(node);
                stack.push(null);
            } else {
                res.add(stack.pop().val);
            }
        }
        return res;
    }

    /**
     * 中序遍历
     *      左中右（左子树入栈）
     */
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (node.right != null) stack.push(node.right);
                stack.push(node);
                stack.push(null);
                if (node.left != null) stack.push(node.left);
            } else {
                res.add(stack.pop().val);
            }
        }
        return res;
    }

    /**
     * 后序遍历
     *      左右中
     */
    private List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                stack.push(node);
                stack.push(null);
                if (node.right != null) stack.push(node.right);
                if (node.left != null) stack.push(node.left);
            } else {
                res.add(stack.pop().val);
            }
        }
        return res;
    }

    /**
     * 层序遍历
     *      队列
     */
    private List<Integer> levelorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            res.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return res;
    }
}
