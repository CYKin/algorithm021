/**
 * @ClassName: _033_Search
 * @Description: 33. 搜索旋转排序数组
 * @Author: wangchangyong
 * @Date: 2020/12/24 21:14
 * @Version: 1.0.0
 **/
public class _033_Search {

    /**
     * 二分查找
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return¡
     */
    public static int search(int[] nums, int target) {
        int result = -1;
        // 直接遍历数组 O(n)
        // for(int i = 0; i < nums.length; i++){
        //     if(nums[i] == target){
        //         result = i;
        //     }
        // }

        // 二分查找 O(logn)
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            // 前面有序
            if (nums[i] <= nums[mid]) {
                if (target > nums[mid] || target < nums[i]) {
                    // 不在前半部分 向前查找
                    i = mid + 1;
                } else {
                    // 向后查找
                    j = mid - 1;
                }
            } else {
                // 后面有序
                if (target < nums[mid] || target > nums[j]) {
                    // 不在后半部分 向前查找
                    j = mid - 1;
                } else {
                    // 向后查找
                    i = mid + 1;
                }
            }
        }
        return result;
    }
}
