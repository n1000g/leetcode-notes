package toclassfy;

import java.util.HashMap;
import java.util.Map;

/**
 * 974. 和可被 K 整除的子数组
 *
 * A = [4,5,0,-2,-3,1]，K=5
 * 所谓的前缀和 P = [4,9,9,7,4,5]
 * 前缀和对K = 5取模 M = [4,4,4,2,4,5]
 * 4对5取模等于4， 4加上一个数对5取模还等于4，说明什么？说明加上的这个数能被5整除。
 *  M[0]和M[1]都等于4，说明A[1]这个数能被5整除。
 * M[0]和M[2]都等于4，说明A[1]+A[2]这个数能被5整除。
 * M[0]和M[4]都等于4，说明A[1]+A[2]+A[3]+A[4]这个数能被5整除。
 *
 * M[1]和M[2]都等于4，说明A[2]这个数能被5整除。
 * M[1]和M[4]都等于4，说明A[2]+A[3]+A[4]这个数能被5整除。
 *
 * M[2]和M[4]都等于4，说明A[3]+A[4]这个数这个数能被5整除。
 *
 * 则M中如果有4个4，说明A中有3+2+1个数可以被5整除。也就是4*（4-1）/2 个数可以被5整除。
 *
 * 推广开来，如果M中有m个n，说明A中有m*（m-1）/2个数可以被K整除。
 * 特别地，如果M中有m个0，结果还要加上m，变为m + m*(m-1)/2。因为比如M[0]和M[1]都等于0，说明A[0]和A[1]都能被K整除。
 */
public class Solution974 {
    public static void main(String[] args) {
        int[] A = {-1, 0, -4, 5, 15};
        int res = new Solution974().subarraysDivByK(A, 5);
        int res2 = new Solution974().subarraysDivByK_2(A, 5);
        System.out.println(res + " " + res2);
    }

    /**
     * dp
     * O(N^2)
     */
    public int subarraysDivByK(int[] A, int K) {
        int res = 0;
        int len = A.length;
        int[][] dp = new int[len][len];
        // dp[i][i] = A[i]
        // dp[i][j] = A[i]+...+A[j] = arr[i][j-1] + A[j]
        for (int i = 0; i < len; i++) {
            dp[i][i] = A[i];
            if (dp[i][i] % K == 0) res++;
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = dp[i][j - 1] + A[j];
                if (dp[i][j] % K == 0) res++;
            }
        }
        return res;
    }

    /**
     * 前缀和
     * O(N)
     */

    public int subarraysDivByK_2(int[] A, int K) {
        Map<Integer, Integer> record = new HashMap<>();
        record.put(0, 1);
        int sum = 0, res = 0;
        for (int elem: A) {
            sum += elem;
            // 注意 Java 取模的特殊性，当被除数为负数时取模结果为负数，需要纠正
            int modulus = (sum % K + K) % K;
            // 模数在记录中存在，加上当前出现次数（第二次出现加1，第三次出现再加2，第四次出现再加3）
            int same = record.getOrDefault(modulus, 0);
            res += same;
            System.out.println(elem +" " + modulus + " " + same + " " + res +" " + record.entrySet());
            record.put(modulus, same + 1);
        }
        return res;
    }

}
