package arrays.binarysearch;

/**
 * 4.两个有序数组的中位数
 * 思路：
 *  对
 *      [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]  m = 10
 *      [1, 2, 4, 9]                     n = 4
 *
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,};
        int[] b = {1, 2, 4, 9,};
        double median = new MedianOfTwoSortedArrays().findMedianSortedArrays(a, b);
        System.out.println(median);
    }

    private double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(a, 0, b, 0, l) + getkth(a, 0, b, 0, r)) / 2.0;
    }

    /**
     * 求两有序数组第 k 小的数
     */
    private int getkth(int[] a, int aStart, int[] b, int bStart, int k) {
        if (aStart > a.length - 1) return b[bStart + k - 1];
        if (bStart > b.length - 1) return a[aStart + k - 1];
        if (k == 1) return Math.min(a[aStart], b[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < a.length) aMid = a[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < b.length) bMid = b[bStart + k/2 - 1];

        if (aMid < bMid) return getkth(a, aStart + k/2, b, bStart, k - k/2);
        else return getkth(a, aStart, b, bStart + k/2, k - k/2);
    }
}
