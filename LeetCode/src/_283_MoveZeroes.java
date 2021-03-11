/**
 * @ClassName: _283_MoveZero
 * @Description: 283. 移动零
 * @Author: wangchangyong
 * @Date: 2020/12/5 21:18
 * @Version: 1.0.0
 **/
public class _283_MoveZeroes {

    /**
     * 数组 + 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // 非零位置
        int j = 0;
        // 非零数前移
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    nums[j] = nums[i];
                }
                j++;
            }
        }
        // 剩余赋值0
        for (int k = j; k < nums.length; k++) {
            nums[k] = 0;
        }
    }

}
