import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _078_Subsets
 * @Description: 78. 子集
 * @Author: wangchangyong
 * @Date: 2020/12/17 21:19
 * @Version: 1.0.0
 **/
public class _078_Subsets {

    /**
     * 分治
     * 时间复杂度：O(logn)
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        // terminator
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        // 分治 每一层可选一个数或不选
        // 不选
        dfs(result, list, nums, index + 1);
        // 选着一个数
        list.add(nums[index]);
        dfs(result, list, nums, index + 1);

        list.remove(list.size()-1);
    }
}
