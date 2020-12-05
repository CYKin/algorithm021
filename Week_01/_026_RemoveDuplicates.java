/**
 * @ClassName: RemoveDuplicates
 * @Description: 26. 删除排序数组中的重复项
 * @Author: wangchangyong
 * @Date: 2020/12/5 20:47
 * @Version: 1.0.0
 **/
public class _026_RemoveDuplicates {

    /**
     * 数组 + 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        // 不重复元素位置
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[++j] = nums[i + 1];
            }
        }
        return ++j;
    }

}

