/**
 * @ClassName: _189_Rotate
 * @Description: 189. 旋转数组
 * @Author: wangchangyong
 * @Date: 2020/12/6 21:49
 * @Version: 1.0.0
 **/
public class _189_Rotate {

    /**
     * 数组
     * 时间复杂度：O(n+k) n为数组长度
     * 空间复杂度：O(k)
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        // 暴力法
        // int len = nums.length;
        // for(int i = 0; i < k;i++){
        //     int temp = nums[len-1];
        //     // 往后移动一位
        //     for(int j = len -2; j >=0; j--){
        //         nums[j + 1] = nums[j];
        //     }
        //     nums[0] = temp;
        // }

        int len = nums.length;
        k = k % len;
        // 保存数组后移k位，超出数组的元素
        int[] out = new int[k];
        for (int i = 0; i < k; i++) {
            out[i] = nums[len - i - 1];
        }
        // nums前len-k个元素后移k位
        for (int j = len - k - 1; j >= 0; j--) {
            nums[j + k] = nums[j];
        }
        // 移除元素放在数l组
        for (int l = 0; l < k; l++) {
            nums[l] = out[k - l - 1];
        }
    }

}
