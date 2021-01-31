import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _018_FourSum
 * @Description: 18. 四数之和
 * @Author: wangchangyong
 * @Date: 2021/1/17 20:05
 * @Version: 1.0.0
 **/
public class _018_FourSum {


    /**
     * 排序 + 双指针
     * a最外层循环，里面嵌套b循环，再嵌套双指针c,d包夹求解
     * 时间复杂度：O(n*n*n)
     * 空间复杂度：
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len < 4) {
            return result;
        }
        // 排序
        Arrays.sort(nums);
        // 循环求解
        for (int a = 0; a < len - 3; a++) {
            // 去重
            if (a > 0 && nums[a - 1] == nums[a]) {
                continue;
            }
            for (int b = a + 1; b < len - 2; b++) {
                // 去重
                if (b > a + 1 && nums[b - 1] == nums[b]) {
                    continue;
                }
                // 双指正包夹求解
                int c = b + 1;
                int d = len - 1;
                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum == target) {
                        setResult(result, new Integer[]{nums[a], nums[b], nums[c], nums[d]});
                        // 去重
                        while (c < d && nums[c] == nums[c + 1]) {
                            c++;
                        }
                        while (c < d && nums[d] == nums[c - 1]) {
                            d--;
                        }
                        c++;
                        d--;
                    } else if (sum > target) {
                        d--;
                    } else if (sum < target) {
                        c++;
                    }
                }
            }
        }
        return result;
    }

    public void setResult(List<List<Integer>> result, Integer[] nums) {
        Arrays.sort(nums);
        List<Integer> numList = Arrays.asList(nums);
        if (!result.contains(numList)) {
            result.add(numList);
        }
    }
}
