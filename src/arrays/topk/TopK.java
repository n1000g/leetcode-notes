package arrays.topk;

import java.util.*;

/**
 * 经典问题 TopK
 *      思路：
 *          频率统计 O(N) + 频率快速排序 O(NlogN) == O(NlogN)
 *          瓶颈在排序
 *      次优：
 *          用一个优先队列维护 topK 在队列内排序
 *          O(N) + O(NlogK)
 *      最优：
 *          桶排序
 *          新建 n 个桶（频率全为 1）
 *
 *
 *
 */
public class TopK {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 4, 5, 5, 5, 6, 7, 5, 7, 7, 8};
        TopK solution = new TopK();
        System.out.println(Arrays.toString(solution.getTopK(arr, 1)));
        System.out.println(Arrays.toString(solution.getTopK(arr, 2)));
        System.out.println(Arrays.toString(solution.getTopK(arr, 3)));
        System.out.println(Arrays.toString(solution.getTopK(arr, 4)));
        System.out.println(Arrays.toString(solution.getTopK(arr, 5)));
    }

    private int[] getTopK(int[] arr, int k) {
        // 空间复杂度 O(n * k)
        List<Integer>[] bucket = new List[arr.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer i : arr) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }
        for (Integer key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
            if (bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
