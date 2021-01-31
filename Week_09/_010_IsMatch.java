/**
 * @ClassName: _010_IsMatch
 * @Description: 10. 正则表达式匹配
 * @Author: wangchangyong
 * @Date: 2021/1/31 17:11
 * @Version: 1.0.0
 **/
public class _010_IsMatch {

    /**
     * 动态规划
     * 时间复杂度：O(m*n)
     * 空间复杂度：O(m*n)
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {

        if (s == null && p == null) {
            return false;
        }

        int sLen = s.length();
        int pLen = p.length();

        // dp[i][j]表示 0-i与0-j字符串是否匹配
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;

        // j=0时，dp[i][0] = false
        // i=0时
        for (int j = 1; j <= pLen; j++) {
            if (j > 1 && p.charAt(j - 1) == '*' && dp[0][j - 2]) {
                dp[0][j] = true;
            }
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                // 没有正则表达式
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 匹配'.'
                if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 匹配'*'
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (s.charAt(i - 1) == p.charAt(j - 2) || '.' == p.charAt(j - 2)) && dp[i - 1][j];
                }
            }
        }

        return dp[sLen][pLen];
    }
}
