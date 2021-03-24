/**
 * @ClassName: BubbleSort
 * @Description: 冒泡排序
 * @Author: wangchangyong
 * @Date: 2021/3/17 21:41
 * @Version: 1.0.0
 **/
public class BubbleSort {

    /**
     * 优化冒泡排序
     * isSort: 标记是否有序，true有序则停止排序比较
     * lastExchangeIndex: 无序数列边界，减少排序
     * 时间复杂度：O(n*n)
     * 空间复杂度：O(1)
     * @param array
     */
    public void bubbleSort_opt(int[] array) {
        // 最后一次交换的位置
        int lastExchangeIndex = 0;
        // 无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            // 有序标记，每一轮的初始是true
            boolean isSort = true;
            for (int j = 0; j < sortBorder; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // 有元素交换，说明数组不是有序，标记变为false
                    isSort = false;
                    // 无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSort) {
                break;
            }
        }
    }

    /**
     * 普通冒泡排序
     * 时间复杂度：O(n*n)
     * 空间复杂度：O(1)
     * @param array
     */
    public void bubbleSort_base(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

}
