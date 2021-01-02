/**
 * @ClassName: _135_Candy
 * @Description: 135. 分发糖果
 * @Author: wangchangyong
 * @Date: 2020/12/24 13:54
 * @Version: 1.0.0
 **/
public class _135_Candy {

    /**
     * 贪心算法
     * 相邻需要考虑左右
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param ratings
     * @return
     */
    public static int candy(int[] ratings) {
        int leastCandy = 0;
        int[] left = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            leastCandy += Math.max(left[i], right);
        }
        return leastCandy;
    }
}
