package unionfind;

/**
 * 并查集
 */
public class UnionFind {

    int[] ancestors;

    public UnionFind(int n) {
        ancestors = new int[n];
        for (int i = 0; i < n; i++) {
            ancestors[i] = i;
        }
    }

    public void union(int i, int j) {
        ancestors[find(i)] = find(j);
    }

    public int find(int n) {
        if (ancestors[n] == n) return n;
        return find(ancestors[n]);
    }

}
