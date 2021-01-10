/**
 * @ClassName: _063_uniquePathsWithObstacles
 * @Description: TODO
 * @Author: wangchangyong
 * @Date: 2021/1/4 17:57
 * @Version: 1.0.0
 **/
public class _063_UniquePathsWithObstacles {

    /**
     * 动态规划
     * DP方程 dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        // 第一行 遇到障碍物后，后边均不能到达
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        // 第一列 遇到障碍物后，后边均不能到达
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }

}
