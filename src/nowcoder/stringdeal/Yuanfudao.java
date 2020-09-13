package nowcoder.stringdeal;

import java.util.Scanner;

/**
 * 输入 s1,s2,s3,n
 * s3 在 s1,s2 前缀中取, n 为可取次数
 * 返回真假
 */
public class Yuanfudao {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //while (scanner.hasNextLine()) {
        //    String s1 = scanner.nextLine();
        //    String s2 = scanner.nextLine();
        //    String s3 = scanner.nextLine();
        //    int n = scanner.nextInt();
        //    System.out.println(new Yuanfudao().dfs(s1, s2, s3, n));
        //}
        String s1 = "aaa";
        String s2 = "ccc";
        String target = "acacac";
        System.out.println(new Yuanfudao().dfs(s1, s2, target, 8));
    }

    private boolean dfs(String s1, String s2, String target, int n) {
        // 递归出口
        if (target.length() == 0) return n >= 0;
        if (n == 0) return false;
        // 求最长公共前缀的下标位置 dif1 和 dif2
        int dif1 = firstIndexOfDifferentChar(s1, target);
        int dif2 = firstIndexOfDifferentChar(s2, target);
        // 没有公共前缀
        if (dif1 == 0 && dif2 == 0) return false;
        // 贪心
        if (dif1 >= dif2) return dfs(s1.substring(dif1), s2, target.substring(dif1), n - 1);
        else return dfs(s1, s2.substring(dif2), target.substring(dif2), n - 1);
    }
    
    private int firstIndexOfDifferentChar(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int len = Math.min(lena, lenb);
        int idx = 0;
        while (idx < len && (a.charAt(idx) == b.charAt(idx))) {
            idx ++;
        }
        return idx;
    }

}
