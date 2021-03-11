/**
 * @ClassName: _643_FindMaxAverage
 * @Description: 643. 子数组最大平均数 I
 * @Author: wangchangyong
 * @Date: 2021/2/4 20:34
 * @Version: 1.0.0
 **/
public class _643_FindMaxAverage {

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        int temp = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if (i > k - 1) {
                temp -= nums[i - k];
            }
            if (i >= k - 1) {
                maxSum = Math.max(maxSum, temp);
            }
        }
        return 1.0 * maxSum / k;
    }

}
