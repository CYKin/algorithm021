import java.util.*;

/**
 * @ClassName: _217_ContainsDuplicate
 * @Description: 217. 存在重复元素
 * @Author: wangchangyong
 * @Date: 2020/12/13 10:59
 * @Version: 1.0.0
 **/
public class _217_ContainsDuplicate {

    /**
     * 数组 + 哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int num : nums) {
        //     map.put(num, map.getOrDefault(num, 0) + 1);
        //     if (map.get(num) >= 2) {
        //         return true;
        //     }
        // }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /**
     * 排序
     * 时间复杂度：O(NlogN)
     * 空间复杂度：O(logN)
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
