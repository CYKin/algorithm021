/**
 * @ClassName: _125_IsPalindrome
 * @Description: 125. 验证回文串
 * @Author: wangchangyong
 * @Date: 2021/1/28 09:14
 * @Version: 1.0.0
 **/
public class _125_IsPalindrome {

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
