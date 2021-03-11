/**
 * @ClassName: _122_MaxProfit
 * @Description: 122. 买卖股票的最佳时机 II
 * @Author: wangchangyong
 * @Date: 2020/12/22 21:27
 * @Version: 1.0.0
 **/
public class _122_MaxProfit {

    /**
     * 贪心算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            // 比前一天大，相减得到两天的最大收益
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

}
