import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ClassName: _040_GetLeastNumbers
 * @Description: 剑指 Offer 40. 最小的k个数
 * @Author: wangchangyong
 * @Date: 2020/12/13 15:59
 * @Version: 1.0.0
 **/
public class _040_GetLeastNumbers {

    /**
     * 排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(logn)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    /**
     * 堆
     * 时间复杂度：O(nlogk)
     * 空间复杂度：O(k)
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] ans = new int[k];
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}
