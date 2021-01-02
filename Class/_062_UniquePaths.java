/**
 * @ClassName: _062_UniquePaths
 * @Description: 62. 不同路径
 * @Author: wangchangyong
 * @Date: 2020/12/29 10:36
 * @Version: 1.0.0
 **/
public class _062_UniquePaths {

    /**
     * 动态规划
     * DP方程：grid[i][j] = grid[i-1][j] + grid[i][j-1]
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    grid[i][j] = 1;
                }else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
