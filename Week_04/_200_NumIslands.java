/**
 * @ClassName: _200_NumIslands
 * @Description: 200. 岛屿数量
 * @Author: wangchangyong
 * @Date: 2020/12/27 19:45
 * @Version: 1.0.0
 **/
public class _200_NumIslands {

    // 行
    private int n;
    // 列
    private int m;

    /**
     * 深度优先搜索
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    // 深度优先连接的的1替换成0
                    dfs(grid, i, j);
                    ++count;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        // 替换成0
        grid[i][j] = '0';
        // 上下左右替换成0
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
