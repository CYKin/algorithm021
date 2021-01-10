import java.util.List;

/**
 * @ClassName: _120_MinimumTotal
 * @Description: 120. 三角形最小路径和
 * @Author: wangchangyong
 * @Date: 2021/1/5 16:06
 * @Version: 1.0.0
 **/
public class _120_MinimumTotal {

    /**
     * 动态规划
     * 解题思路：自底向上
     * DP方程：dp[i][j] = Math.min(dp[i+1][j], dp[i+i][j+1]) + triangle[i][j]
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // int[] dp = new int[n + 1];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= n; j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j));
            }
        }
        return triangle.get(0).get(0);

        // 空间复杂度：O(n)
        // int n = triangle.size();
        // int[] dp = new int[n + 1];
        // for (int i = n - 1; i >= 0; i--) {
        //     for (int j = 0; j <= i; j++) {
        //         dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
        //     }
        // }
        // return dp[0];
    }

    Integer[][] nums;

    /**
     * 递归 + 记忆化搜索
     * 解题思路：自顶向下
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * @param triangle
     * @return
     */
    public int minimumTotalRecur(List<List<Integer>> triangle) {
        nums = new Integer[triangle.size()][triangle.size()];
        return recur(0, 0, triangle);
    }

    public int recur(int level, int i, List<List<Integer>> triangle) {
        if (level == triangle.size() - 1) {
            return triangle.get(level).get(i);
        }
        if (nums[level][i] != null) {
            return nums[level][i];
        }
        // 分治 下一层的左右两个节点
        int left = recur(level + 1, i, triangle);
        int right = recur(level + 1, i + 1, triangle);
        // 当前层最小路径和 = 当前层最小节点 + 上一层最小路径和
        nums[level][i] = Math.min(left, right) + triangle.get(level).get(i);
        return nums[level][i];
    }
}
