package toclassfy;

/**
 * 74. 搜索二维矩阵
 *     二维矩阵上的二分查找
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 *
 */
class Solution74 {

    // 一维有序数组的二分查找
    public static boolean binarySearch(int[] arr, int target) {
        int len = arr.length;
        int left = 0, right = len - 1;
        int mid = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (arr[mid] == target) return true;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    /**
     * 领域缩小
     *      左下角到右上角 O(M+N)
     *      matrix[r][c] > target ==> c--
     *      matrix[r][c] < target ==> r++
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1) return false;
        if (matrix[0].length < 1) return false;
        int row = matrix.length - 1, col = 0;
        while (row > -1 && col < matrix[0].length) {
            if (matrix[row][col] > target) row--;
            else if (matrix[row][col] < target) col++;
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(searchMatrix(matrix, 3)? "TRUE" : "FALSE");
        System.out.println(searchMatrix(matrix, 13)? "TRUE" : "FALSE");
        System.out.println(searchMatrix(matrix, 34)? "TRUE" : "FALSE");

        int[] arr = {1, 2, 3, 5, 10, 100, 200, 1000, 30000, 30001};
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, 101));
        System.out.println(binarySearch(arr, 200));
    }
}
