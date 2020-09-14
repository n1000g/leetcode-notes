package dfs.traceback;

import java.util.Arrays;

/**
 * 数组的全排列
 */
public class FullPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        FullPermutation solution = new FullPermutation();
        solution.fullPermutation(arr, 0);
        System.out.println(solution.counts);
    }

    int counts = 0;

    public void fullPermutation(int[] arr, int cur) {
        if (cur == arr.length) {
            ++ counts;
            System.out.println(Arrays.toString(arr));
        }
        for (int i = cur; i < arr.length; i++) {
            // a[i] + arr[cur + 1...] 的全排列
            {int tmp = arr[i]; arr[i] = arr[cur]; arr[cur] = tmp;}
            fullPermutation(arr, cur + 1);
            {int tmp = arr[i]; arr[i] = arr[cur]; arr[cur] = tmp;}
        }
    }

}
