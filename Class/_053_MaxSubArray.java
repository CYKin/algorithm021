/**
 * @ClassName: _053_MaxSubArray
 * @Description: 53. 最大子序和
 * @Author: wangchangyong
 * @Date: 2021/1/5 21:34
 * @Version: 1.0.0
 **/
public class _053_MaxSubArray {

    /**
     * 动态规划
     * DP方程：dp[i] = max(nums[i], nums[i] + dp[i-1])
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        // DP数组为当前和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        // 最大和
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 当前最大和 = 仅当前元素最大 || 当前元素+之前元素和为最大
            dp[i] = Math.max(0, dp[i - 1]) + nums[i];
            // 当前和与最大和比较
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

}
