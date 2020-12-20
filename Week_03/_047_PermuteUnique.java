import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _047_PermuteUnique
 * @Description: 47. 全排列 II
 * @Author: wangchangyong
 * @Date: 2020/12/20 14:01
 * @Version: 1.0.0
 **/
public class _047_PermuteUnique {

    /**
     * 递归
     * 时间复杂度：O(n∗n!)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
        // 结束条件
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        }

        // 循环插入一个不重复元素
        for (int i = 0; i < nums.length; i++) {
            // 通过下标位置标记元素是否已被使用，使用回溯
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            tempList.add(nums[i]);
            // 下层递归
            backtrack(list, tempList, nums, used);

            // 清除当前层
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
