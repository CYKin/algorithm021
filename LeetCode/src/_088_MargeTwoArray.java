import java.util.Arrays;

/**
 * @ClassName: _088_MargeTwoArray
 * @Description: 88. 合并两个有序数组
 * @Author: wangchangyong
 * @Date: 2020/12/6 20:50
 * @Version: 1.0.0
 **/
public class _088_MargeTwoArray {

    /**
     * 数组 + 双指针
     * 时间复杂度：O(n+m)
     * 空间复杂度：
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // for(int j = 0; j < n;j++){
        //     nums1[m+j] = nums2[j];
        // }
        // Arrays.sort(nums1);

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }

        }
        // m = 0
        while (j >= 0) {
            nums1[k--] = nums1[j--];
        }
    }
}
