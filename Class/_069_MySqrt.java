/**
 * @ClassName: _069_MySqrt
 * @Description: 69. x 的平方根
 * @Author: wangchangyong
 * @Date: 2020/12/23 21:51
 * @Version: 1.0.0
 **/
public class _069_MySqrt {

    /**
     * 牛顿迭代法
     * 时间复杂度：O()
     * 空间复杂度：O(1)
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
}
