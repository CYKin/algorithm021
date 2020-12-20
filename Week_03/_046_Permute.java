import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _046_Permute
 * @Description: 46. 全排列
 * @Author: wangchangyong
 * @Date: 2020/12/20 13:12
 * @Version: 1.0.0
 **/
public class _046_Permute {


    /**
     * 递归
     * 时间复杂度：O(n∗n!)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {

        // 结束条件
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        // 循环插入一个不重复元素
        for (int i = 0; i < nums.length; i++) {
            // 重复元素回溯
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            // 下层递归
            backtrack(list, tempList, nums);
            // 清除当前层
            tempList.remove(tempList.size() - 1);
        }
    }
}
