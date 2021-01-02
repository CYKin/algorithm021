/**
 * @ClassName: _091_NumDecodings
 * @Description: 91. 解码方法
 * @Author: wangchangyong
 * @Date: 2020/12/30 16:50
 * @Version: 1.0.0
 **/
public class _091_NumDecodings {

    /**
     * 动态规划
     * dp[i] = dp[i-1] + dp[i-2]
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @return
     */
    public int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= s.length(); i++) {
            int charOne = Integer.parseInt(s.substring(i - 1, i));
            int charTwo = Integer.parseInt(s.substring(i - 2, i));

            // 一个数据有效
            if (charOne >= 1 && charOne <= 9) {
                dp[i] = dp[i - 1];
            }

            // 两个数字有效
            if (charTwo >= 10 && charTwo <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

}
