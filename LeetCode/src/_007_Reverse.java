/**
 * @ClassName: _007_Reverse
 * @Description: 7. 整数反转
 * @Author: wangchangyong
 * @Date: 2021/3/29 21:56
 * @Version: 1.0.0
 **/
public class _007_Reverse {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            // 最小值
            if (rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            // 最大值
            if (rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
