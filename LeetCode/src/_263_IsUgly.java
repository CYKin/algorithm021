/**
 * @ClassName: _263_IsUgly
 * @Description: TODO
 * @Author: wangchangyong
 * @Date: 2021/4/10 20:45
 * @Version: 1.0.0
 **/
public class _263_IsUgly {

    /**
     * n 对 2 3 5 整除，结果n=1是丑数
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public boolean isUgly(int n) {

        // 小于等于0不是丑数
        if (n <= 0) {
            return false;
        }

        // 能否被5整除
        while (n % 5 == 0) {
            n /= 5;
        }
        // 能否被3整除
        while (n % 3 == 0) {
            n /= 3;
        }
        // 能否被2整除
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

}
