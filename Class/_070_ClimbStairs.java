/**
 * @ClassName: _070_ClimbStairs
 * @Description: 70. 爬楼梯
 * @Author: wangchangyong
 * @Date: 2020/12/14 21:11
 * @Version: 1.0.0
 **/
public class _070_ClimbStairs {

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        // 斐波拉契数列
        if(n <= 2){
            return n;
        }

        int[] ftm = new int[n + 1];
        ftm[1] = 1;
        ftm[2] = 2;

        for (int i = 3; i <= n; i++) {
            ftm[i] = ftm[i - 1] + ftm[i - 2];
        }
        return ftm[n];
    }

}
