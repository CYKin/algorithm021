/**
 * @ClassName: _005_LongestPalindrome
 * @Description: 5. 最长回文子串
 * @Author: wangchangyong
 * @Date: 2021/1/28 22:03
 * @Version: 1.0.0
 **/
public class _005_LongestPalindrome {

    /**
     * 中心扩散法
     * 时间复杂度：O(n*n)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        String maxStr = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            // 奇数中心回文字符串
            String oddStr = subPalindrome(s, i, i);
            // 偶数中心回文字符串
            String evenStr = subPalindrome(s, i, i + 1);
            String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            if (maxLenStr.length() > maxStr.length()) {
                maxStr = maxLenStr;
            }
        }
        return maxStr;
    }

    public static String subPalindrome(String s, int left, int right) {
        int i = left;
        int j = right;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }
}
