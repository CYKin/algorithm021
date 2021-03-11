/**
 * @ClassName: _153_FindMin
 * @Description: 153. 寻找旋转排序数组中的最小值
 * @Author: wangchangyong
 * @Date: 2020/12/25 09:05
 * @Version: 1.0.0
 **/
public class _153_FindMin {

    /**
     * 寻找旋转排序数组中的最小值
     * 二分查找
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        // 初始最小值
        int min = nums[0];

        while (i <= j) {
            int mid = i + (j - i) / 2;
            // 前半部分升序
            if (nums[i] <= nums[mid]) {
                // 前半部分第一个数与最小数取值min
                min = Math.min(min, nums[i]);
                // 查找后半部分区间最小数
                i = mid + 1;
            } else {
                // 后半部分升序 后半部分第一个数与最小数取值min
                min = Math.min(min, nums[mid]);
                // 查找前半部分区间最小数
                j = mid - 1;
            }
        }
        return min;
    }

    /**
     * 寻找旋转排序数组中间无序的地方 -> 寻找旋转排序数组中最小值的index
     * 二分查找
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int findMinIndex(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        // 初始化最小值和最小值index
        int min = nums[0];
        int minIndex = 0;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            // 前半部分升序
            if (nums[i] <= nums[mid]) {
                // 前半部分第一个数与最小数取值min
                if (min > nums[i]) {
                    min = nums[i];
                    minIndex = i;
                }
                // 查找后半部分区间最小数和index
                i = mid + 1;
            } else {
                // 后半部分升序 后半部分第一个数与最小数取值min
                if (min > nums[mid]) {
                    min = nums[mid];
                    minIndex = mid;
                }
                // 查找前半部分区间最小数和index
                j = mid - 1;
            }
        }
        return minIndex;
    }
}
