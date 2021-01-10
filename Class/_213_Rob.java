import java.util.Arrays;

/**
 * @ClassName: _213_Rob
 * @Description: 213. 打家劫舍 II
 * @Author: wangchangyong
 * @Date: 2021/1/7 20:54
 * @Version: 1.0.0
 **/
public class _213_Rob {

    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        // 第一个偷和最后一个不偷
        int first = mRob(Arrays.copyOfRange(nums, 0, n - 1));
        // 第一个不偷和最后一个偷
        int second = mRob(Arrays.copyOfRange(nums, 1, n));
        // 取最大值
        return Math.max(first, second);
    }

    public static int mRob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }
}
