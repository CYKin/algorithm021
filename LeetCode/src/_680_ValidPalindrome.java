/**
 * @ClassName: _680_ValidPalindrome
 * @Description: 680. 验证回文字符串 Ⅱ
 * @Author: wangchangyong
 * @Date: 2021/1/28 10:00
 * @Version: 1.0.0
 **/
public class _680_ValidPalindrome {

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                // 删除一个字符再判断是否是回文字符串
                // 删除左边一个字符 i+1 ~ j
                boolean left = true;
                for (int a = i + 1, b = j; a < b; a++, b--) {
                    if (s.charAt(a) != s.charAt(b)) {
                        left = false;
                        break;
                    }
                }
                // 删除左边一个字符 i ~ j-1
                boolean right = true;
                for (int a = i, b = j - 1; a < b; a++, b--) {
                    if (s.charAt(a) != s.charAt(b)) {
                        right = false;
                        break;
                    }
                }
                return left || right;
            }
        }
        return true;
    }

}
