package util;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 转换 io 的字符串为题目要求 io 类型
 *      API List：
 *          String -> String[]
 *          String -> int[]
 * @author: n8g
 * @createDate: 2020/9/6
 */
public class StringUtils {

    /**
     * 对 leetcode 输入格式简化
     *      leetcode 输入格式 ["aaa", "bbb", "ccc"]
     *      定义输入格式为 aaa,bbb,ccc
     */
    public static String[] stringToStringArray(String input) {
        input = input.trim();
        if (input.length() == 0) {
            return new String[0];
        }
        String[] parts = input.split(",");
        String[] output = new String[parts.length];
        for (int index = 0; index < parts.length; index++) {
            output[index] = parts[index].trim();
        }
        return output;
    }

    /**
     * String -> int[]
     *      input: "[1,2,3,4,5]"
     *      output: [1,2,3,4,5]
     */
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static <T> String integerArrayListToString(List<T> list) {
        return list.toString();
    }

    /**
     * String -> BTree(int val)
     *      input: "1,2,3,null,4,null,5,null,null,6,7,null,null,null,8"
     *      output:     1
     *                /   \
     *              2      3
     *               \      \
     *                4      5
     *                      / \
     *                     6   7
     *                          \
     *                           8
     */
    public static TreeNode stringToBinaryTree(String input) {
        if (input.length() == 0) return null;
        String[] stringVals = input.trim().split(",");
        if (stringVals.length == 0) return null;
        Deque<TreeNode> nodeQueue = new LinkedList<>();
        String item = stringVals[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        nodeQueue.add(root);

        int idx = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (idx == stringVals.length) break;

            item = stringVals[idx ++].trim();
            if (!item.contentEquals("null")) {
                int leftVal = Integer.parseInt(item);
                node.left = new TreeNode(leftVal);
                nodeQueue.add(node.left);
            }

            if (idx == stringVals.length) break;

            item = stringVals[idx ++].trim();
            if (!item.contentEquals("null")) {
                int rightVal = Integer.parseInt(item);
                node.right = new TreeNode(rightVal);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    /**
     * TODO: List<List<String>> -> String
     * List<T extends ???> -> String
     */
}
