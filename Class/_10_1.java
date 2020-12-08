import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _10_1
 * @Description: TODO
 * @Author: wangchangyong
 * @Date: 2020/12/8 15:47
 * @Version: 1.0.0
 **/
public class _10_1 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};
        System.out.println("数组是否有重复数据：" + solution1(nums));

        int[] values = {60,30,50,40,60};
        int[] weights = {2,2,6,5,4};
        int max = 10;
        System.out.println("挖出最大量是：" + solution2(values, weights, max));
    }


    /**
     * 判断重复
     * 数组 + 哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public static boolean solution1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 1);
            }
        }
        return false;
    }

    /**
     * @param values  物品的价值
     * @param weights 物品的重量
     * @param max     最大承载量
     * @return
     */
    public static int solution2(int[] values, int[] weights, int max) {
        if (values == null || values.length == 0) {
            return 0;
        }
        if (weights == null || weights.length == 0) {
            return 0;
        }
        if (values.length != weights.length || max <= 0) {
            return 0;
        }

        int[][] dp = new int[values.length + 1][max + 1];
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= max; j++) {
                if (weights[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int proValue = dp[i - 1][j];
                    int curValue = values[i - 1] + dp[i - 1][j - weights[i - 1]];
                    dp[i][j] = Math.max(proValue, curValue);
                }
            }
        }
        int mv = dp[values.length][max];
        int j = max;
        String numStr = "";
        for (int i = values.length; i > 0; i--) {
            if (dp[i][j] > dp[i - 1][j]) {
                numStr = i + " " + numStr;
                j = j - weights[i - 1];
            }
            if (j == 0) {
                break;
            }
        }
        System.out.println("选择的金矿有：" + numStr);
        return mv;
    }


}
