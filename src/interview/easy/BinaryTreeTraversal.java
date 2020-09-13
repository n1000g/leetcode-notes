package interview.easy;

import java.util.Scanner;

/**
 * @description: 前序中序求后序
 *               ABC
 *               BAC
 *               FDXEAG
 *               XDEFAG
 * @author: n8g
 * @createDate: 2020/9/9
 */
public class BinaryTreeTraversal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String preorder = sc.nextLine();
            String inorder = sc.nextLine();
            String postorder = new BinaryTreeTraversal().traversal(preorder, inorder);
            System.out.println(postorder);
        }
    }

    private String traversal(String preorder, String inorder) {
        // 0. 处理递归出口
        // 1. 在中序串中定位根节点下标 idx
        // 2. 递归求解
        int len = preorder.length();
        if (len < 2) return preorder;
        char root = preorder.charAt(0);
        int idx = 0;
        while (inorder.charAt(idx) != root) {
            idx ++;
        }
        String left = traversal(preorder.substring(1, idx + 1), inorder.substring(0, idx));
        String right = traversal(preorder.substring(idx + 1, len), inorder.substring(idx + 1, len));
        return left + right + root;
    }

}