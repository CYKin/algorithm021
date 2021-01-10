/**
 * @ClassName: _198_Rob
 * @Description: 198. 打家劫舍
 * @Author: wangchangyong
 * @Date: 2021/1/6 22:03
 * @Version: 1.0.0
 **/
public class _198_Rob {

    /**
     * 动态规划
     * DP方程：dp[i] = max(dp[i-1], dp[i-2]+nums[i])
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
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
