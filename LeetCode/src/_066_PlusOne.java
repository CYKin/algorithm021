/**
 * @ClassName: _066_PlusOne
 * @Description: 66. 加一
 * @Author: wangchangyong
 * @Date: 2020/12/5 21:34
 * @Version: 1.0.0
 **/
public class _066_PlusOne {

    /**
     * 数组
     * 时间复杂度：O(1)/O(n)
     * 空间复杂度：O(n)
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int value = digits[i] + 1;
            if (value % 10 != 0) {
                digits[i] = value;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
