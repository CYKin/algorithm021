import java.util.Arrays;

/**
 * @ClassName: _322_CoinChange
 * @Description: 322. 零钱兑换
 * @Author: wangchangyong
 * @Date: 2021/1/6 21:33
 * @Version: 1.0.0
 **/
public class _322_CoinChange {

    /**
     * 动态规划
     * DP方程：dp[i] = min(dp[i-n]) + 1
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(n)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // amount兑换最小硬币数
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 硬币小于等于零钱可兑换
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
