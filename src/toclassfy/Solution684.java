package toclassfy;

import java.util.Arrays;

/**
 * 684. 冗余连接
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树
 *
 *      输入: [[1,2], [1,3], [2,3]]
 *      输出: [2,3]
 *      解释: 给定的无向图为:
 *        1
 *       / \
 *      2 - 3
 */
public class Solution684 {
    public static void main(String[] args) {
        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int[][] edges2 = {{1,4}, {3,4}, {1,3}, {1,2}, {4,5}};
        int[] res = findRedundantConnection(edges);
        int[] res2 = findRedundantConnection(edges2);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(res2));
    }

    /**
     * 并查集
     */
    public static int[] findRedundantConnection(int[][] edges) {
        int[] sets = new int[edges.length + 1];

        for(int[] edge : edges) {
            int u = find(sets, edge[0]);
            int v = find(sets, edge[1]);
            if(u == v)
                return edge;
            sets[u] = v;
        }

        return new int[]{};
    }

    private static int find(int[] sets, int v) {
        return sets[v] == 0 ? v : find(sets, sets[v]);
    }
}
