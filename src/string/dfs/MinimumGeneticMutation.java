package string.dfs;

import java.util.HashSet;

/**
 * 433. 最小基因变化
 *
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 *
 * 返回值: 3
 *
 * 子问题
 * s  "AAA"
 * e  "CCC"
 * b ["AAC", "ACC", "CCC"]
 *
 * s  "AAC"
 * e  "CCC"
 * b ["ACC", "CCC"]
 */
public class MinimumGeneticMutation {

    int res = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        // dfs
        HashSet<String> step = new HashSet<>();
        dfs(step, 0, start, end, bank);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(HashSet<String> step, int stepCount, String current, String end, String[] bank) {
        if (current.equals(end)) res = Math.min(res, stepCount);
        if (stepCount > res) return;
        // 遍历 bank 找到和 current 差一步的 setItem
        for (String b : bank) {
            if (differentCharCountsEqualsOne(b, current) && !step.contains(b)) {
                step.add(b);
                dfs(step, stepCount + 1, b, end, bank);
                step.remove(b);
            }
        }
    }

    private boolean differentCharCountsEqualsOne(String a, String b) {
        // a.length() == b.length()
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff ++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }


    public static void main(String[] args) {
        String start = "AAA";
        String end = "CCC";
        String[] bank = {"AAC", "ACC", "CCC"};
        int res = new MinimumGeneticMutation().minMutation(start, end, bank);
        System.out.println(res);
        System.out.println(new MinimumGeneticMutation().differentCharCountsEqualsOne("AAA", "ABB"));
    }
}
