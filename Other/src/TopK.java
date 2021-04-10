import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName: TopK
 * @Description: TODO
 * @Author: wangchangyong
 * @Date: 2021/2/19 20:56
 * @Version: 1.0.0
 **/
public class TopK {

    /**
     * 返回数据第K大的数
     * 小顶堆/大顶堆
     * 时间复杂度：O(n)
     * 空间复杂度：O(k)
     * @param arr
     * @param k
     * @return
     */
    public int topK(int[] arr, int k) {

        // 小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.stream(arr).forEach(num -> {
            // 去重
            if (queue.contains(num)) {
                return;
            }
            // TOP K
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                Integer peek = queue.peek();
                if (num > peek) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        });
        return queue.poll();
    }
}
