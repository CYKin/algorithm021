/**
 * @ClassName: _152_MaxProduct
 * @Description: 152. 乘积最大子数组
 * @Author: wangchangyong
 * @Date: 2021/1/5 22:10
 * @Version: 1.0.0
 **/
public class _152_MaxProduct {

    /**
     * 动态规划
     * DP方程：curMax = Math.max(nums[i], nums[i] * curMax)
     *  如果为负数：curMin = Math.min(nums[i], nums[i] * curMin)
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0], curMax = nums[0], curMin = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }
            curMax = Math.max(nums[i], nums[i] * curMax);
            curMin = Math.min(nums[i], nums[i] * curMin);
            max = Math.max(curMax, max);
        }
        return max;
    }
}
