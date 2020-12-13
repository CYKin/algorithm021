import java.util.*;

/**
 * @ClassName: _347_TopKFrequent
 * @Description: 347. 前 K 个高频元素
 * @Author: wangchangyong
 * @Date: 2020/12/13 16:22
 * @Version: 1.0.0
 **/
public class _347_TopKFrequent {

    /**
     * 桶排序
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent1(int[] nums, int k) {
        int[] ans = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        // 统计数组元素出现频次
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 排序 出现频次作为数组下标
        List<Integer>[] bucket = new ArrayList[nums.length];
        for (Integer key : map.keySet()) {
            int i = map.get(key);
            if (bucket[i] == null) {
                bucket[i] = new ArrayList();
            }
            bucket[i].add(key);
        }

        // 获取前K个高频元素
        int len = 0;
        for (int i = bucket.length - 1; i >= 0 && len < k; i--) {
            List<Integer> list = bucket[i];
            if (list != null) {
                for (int j = 0; j < list.size() && len < k; j++) {
                    ans[len++] = list.get(j);
                }
            }
        }
        return ans;
    }

    /**
     * 堆
     * 时间复杂度：O(nlogk)
     * 空间复杂度：O(n)
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        int[] ans = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        // 统计数组元素出现频次
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 小顶堆 重写比较方法 比较元素出现频次
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (Integer key : map.keySet()) {
            if (heap.size() < k) {
                heap.add(key);
            } else if (map.get(key) > map.get(heap.peek())) {
                heap.remove();
                heap.add(key);
            }
        }

        // 获取前K个高频元素
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}
