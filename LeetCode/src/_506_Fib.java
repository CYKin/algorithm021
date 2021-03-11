/**
 * @ClassName: _506_Fib
 * @Description: TODO
 * @Author: wangchangyong
 * @Date: 2021/1/4 15:39
 * @Version: 1.0.0
 **/
public class _506_Fib {

    /**
     * 迭代
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] nums = new int[n];
        nums[0] = 0;
        nums[1] = 1;

        for (int i = 2; i < n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }

}
