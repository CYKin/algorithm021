import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _077_Combine
 * @Description: 77. 组合
 * @Author: wangchangyong
 * @Date: 2020/12/19 19:50
 * @Version: 1.0.0
 **/
public class _077_Combine {

    /**
     * 递归
     * 时间复杂度：O(n*n!)
     * 空间复杂度：O(n)
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        dfs(combs, new ArrayList<>(), 1, n, k);
        return combs;
    }

    /**
     * @param combs 返回结果
     * @param comb  中间变量
     * @param start 当前层开始循环元素
     * @param n     结束元素
     * @param k     元素个数
     */
    public void dfs(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        // 结束条件
        if (k == 0) {
            combs.add(new ArrayList<>(comb));
            return;
        }

        // 循环插入一个数
        for (int i = start; i <= n; i++) {
            comb.add(i);
            // 下层递归
            dfs(combs, comb, i + 1, n, k - 1);
            // 清除当前层
            comb.remove(comb.size() - 1);
        }
    }
}
