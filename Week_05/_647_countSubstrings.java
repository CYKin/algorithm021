/**
 * @ClassName: _647_countSubstrings
 * @Description: 647. 回文子串
 * @Author: wangchangyong
 * @Date: 2021/01/03 18:43
 * @Version: 1.0.0
 **/
public class _647_countSubstrings {

    /**
     * 动态规划
     * DP方程：dp[i][j] = dp[i+1][j-1]
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        char[] ch = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (ch[i] == ch[j] && (i - j < 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

}
