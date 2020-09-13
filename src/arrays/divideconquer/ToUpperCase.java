package arrays.divideconquer;

public class ToUpperCase {
    public static void main(String[] args) {
        String s = "netstat wc git reset --hard git reflog";
        ToUpperCase solution = new ToUpperCase();
        String res = solution.toUpperCase(s);
        System.out.println(res);
    }

    private String toUpperCase(String s) {
        return toUpperCase(s, 0, s.length() - 1);
    }

    private String toUpperCase(String s, int left, int right) {
        // 模拟分治，不具体写逻辑了
        if (right == left) return s.substring(left, right + 1).toUpperCase();
        int mid = (left + right) / 2;
        return toUpperCase(s, left, mid) + toUpperCase(s, mid + 1, right);
    }

}
