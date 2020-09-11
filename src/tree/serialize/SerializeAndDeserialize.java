package tree.serialize;

import util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class SerializeAndDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String data = "[";
        StringBuilder sb = new StringBuilder(data);
        // 层序遍历
        if (root == null) return sb.append("]").toString(); // 不会出现 "[null,]"
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != null) {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null,");
            }
        }
        return sb.append("]").toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.contentEquals("[]")) return null;
        String[] items = data.substring(1, data.length() - 2).trim().split(",");
        String item = items[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()) {
            if (index == items.length) break;
            TreeNode node = queue.remove();
            item = items[index ++].trim();
            if (!item.contentEquals("null")) {
                node.left = new TreeNode(Integer.parseInt(item));
                queue.add(node.left);
            }

            if (index == items.length) break;
            item = items[index ++].trim();
            if (!item.contentEquals("null")) {
                node.right = new TreeNode(Integer.parseInt(item));
                queue.add(node.right);
            }
        }
        return root;
    }
    
    public static void main(String[] args) {
        SerializeAndDeserialize sad = new SerializeAndDeserialize();
        /** 层序遍历
         *              1
         *            /   \
         *           2     3
         *          /     /
         *         4     5
         *                \
         *                 6
         * [1,2,3,4,null(2r),null(4l),null(4r),5,null(3r),null(5l),6,null,null,]
         */
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        e.right = f;
        System.out.println("-----------serialize---------");
        System.out.println(sad.serialize(a));
        System.out.println("----------deserialize--------");
        TreeNode root = sad.deserialize(sad.serialize(a));
        System.out.println(sad.equals(root, a));
    }

    public boolean equals(TreeNode a, TreeNode b) {
        if (a == null) return b == null;
        if (b == null) return false;
        if (a.val != b.val) return false;
        return (equals(a.left, b.left) && equals(a.right, b.right));
    }
}
