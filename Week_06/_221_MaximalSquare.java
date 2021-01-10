/**
 * @ClassName: _221_MaximalSquare
 * @Description: 221. 最大正方形
 * @Author: wangchangyong
 * @Date: 2020/12/30 20:43
 * @Version: 1.0.0
 **/
public class _221_MaximalSquare {

    /**
     * 动态规划
     * dp[i][j]=min(dp[i][j−1],dp[i−1][j],dp[i−1][j−1])+1
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // 包含 1 的正方形的边长最大
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
