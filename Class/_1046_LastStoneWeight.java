import java.util.PriorityQueue;

/**
 * @ClassName: _1046_LastStoneWeight
 * @Description: 1046. 最后一块石头的重量
 * @Author: wangchangyong
 * @Date: 2020/12/30 10:17
 * @Version: 1.0.0
 **/
public class _1046_LastStoneWeight {

    /**
     * 大顶堆
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     * @param stones
     * @return
     */
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            pq.offer(pq.poll() - pq.poll());
        }
        return pq.poll();
    }

}
