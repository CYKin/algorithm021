/**
 * @ClassName: _1143_LongestCommonSubsequence
 * @Description: 1143. 最长公共子序列
 * @Author: wangchangyong
 * @Date: 2020/12/30 16:13
 * @Version: 1.0.0
 **/
public class _1143_LongestCommonSubsequence {

    /**
     * 动态规划
     * dp方程：dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
     * 解题思路：
     *  用两个指针 i 和 j 从后往前遍历 s1 和 s2，如果 s1[i]==s2[j]，那么这个字符一定在 lcs 中；
     *  否则，s1[i] 和 s2[j] 这两个字符至少有一个不在 lcs 中，需要丢弃一个
     *  dp[i-1][j-1] 永远比dp[i - 1][j], dp[i][j - 1]小，没有必要比较
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();

        int m = ch1.length;
        int n = ch2.length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 最后一个字符相同
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 最后字符不同，取i，j后移一位的最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

}
