package arrays.subarray;

import java.util.ArrayList;
import java.util.List;

/**
 *  迭代
 *  []
 *  [1]
 *  [2] [1,2]
 *  [3] [1,3] [2,3] [1,2,3]
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            // 每个元素加到每个解里生成新的解
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newItem = new ArrayList<>(res.get(i));
                newItem.add(num);
                res.add(newItem);
            }
        }
        return res;
    }
}
