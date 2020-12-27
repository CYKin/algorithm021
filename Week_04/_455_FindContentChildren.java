import java.util.Arrays;

/**
 * @ClassName: _455_FindContentChildren
 * @Description: 455. 分发饼干
 * @Author: wangchangyong
 * @Date: 2020/12/22 21:49
 * @Version: 1.0.0
 **/
public class _455_FindContentChildren {

    /**
     * 贪心算法
     * 时间复杂度：O(mlogm+nlogn)
     * 空间复杂度：O(logm+logn)
     * @param g 孩子胃口
     * @param s 饼干尺寸
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        int max = 0;
        // 升序排序
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            // 孩子胃口刚好满足饼干尺寸且饼干尺寸最小最优，最终得到满足越多
            if (g[i] <= s[j]) {
                max++;
                i++;
            }
            j++;
        }
        return max;
    }


}
