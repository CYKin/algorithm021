/**
 * @ClassName: _121_MaxProfit
 * @Description: 121. 买卖股票的最佳时机
 * @Author: wangchangyong
 * @Date: 2021/1/7 21:40
 * @Version: 1.0.0
 **/
public class _121_MaxProfit {

    /**
     * 动态规划
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // 最小值
        int min = Integer.MAX_VALUE;
        // 最大利润
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }
}
