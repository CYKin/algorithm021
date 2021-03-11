import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: _056_Merge
 * @Description: 56. 合并区间
 * @Author: wangchangyong
 * @Date: 2021/1/24 16:36
 * @Version: 1.0.0
 **/
public class _056_Merge {

    /**
     * 排序
     * 时间复杂度：nlog(n)
     * 空间复杂度：log(n)
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 区间左端点排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> result = new ArrayList<>();
        // 合并区间
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            // 当前区间左端点大于合并区间的右端点，连个区间不重合
            if (interval[0] > newInterval[1]) {
                // 当前区间为新的合并区间
                newInterval = interval;
                result.add(interval);
            } else {
                // 区间重合，取两个区间最大右端点
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
