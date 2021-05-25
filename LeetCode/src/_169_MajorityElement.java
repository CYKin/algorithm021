/**
 * @ClassName: _169_MajorityElement
 * @Description: 169. 多数元素
 * @Author: wangchangyong
 * @Date: 2021/4/25 22:14
 * @Version: 1.0.0
 **/
public class _169_MajorityElement {

    /**
     * 投票法：major是多数元素，投票一定超过一半
     * 如果major是多数元素，相等+1，不等-1，如果最后major的count>0，则major是多数元素
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count = 1;
            } else if (major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
