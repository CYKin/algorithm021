import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: TwoSum
 * @Description: 1. 两数之和
 * @Author: wangchangyong
 * @Date: 2020/12/5 20:55
 * @Version: 1.0.0
 **/
public class _001_TwoSum {

    /**
     * 数组 + 哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (map.containsKey(value)) {
                result[0] = map.get(value);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }

}
