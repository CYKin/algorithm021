/**
 * @ClassName: _072_MinDistance
 * @Description: 72. 编辑距离
 * @Author: wangchangyong
 * @Date: 2021/1/27 22:03
 * @Version: 1.0.0
 **/
public class _072_MinDistance {

    /**
     * 动态规划
     * DP方程：
     *  当 word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]
     *  当 word1[i] != word2[j]，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
     *    dp[i-1][j-1]    替换相同，向后移一位
     *    dp[i-1][j]      删除操作
     *    dp[i][j-1]      插入操作
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // 第一列 word1转换成空的word2 删除操作
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        // 第一行 word1为空转换成word2 插入操作
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

}
