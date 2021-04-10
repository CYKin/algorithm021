/**
 * @ClassName: _064_MinPathSum
 * @Description: 64. 最小路径和
 * @Author: wangchangyong
 * @Date: 2020/12/29 09:38
 * @Version: 1.0.0
 **/
public class _064_MinPathSum {

    /**
     * 动态规划
     * DP方程：grid[m][n] = Math.min(grid[m - 1][n], grid[m][n - 1]) + grid[m][n]
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(1)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        for (int m = 0; m < grid.length; m++) {
            for (int n = 0; n < grid[0].length; n++) {
                if (m == 0 && n != 0) {
                    grid[m][n] = grid[m][n] + grid[m][n - 1];
                } else if (m != 0 && n == 0) {
                    grid[m][n] = grid[m][n] + grid[m - 1][n];
                } else if (m != 0 && n != 0) {
                    grid[m][n] = Math.min(grid[m - 1][n], grid[m][n - 1]) + grid[m][n];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
