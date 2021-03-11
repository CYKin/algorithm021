import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _003_LengthOfLongestSubstring
 * @Description: 3. 无重复字符的最长子串
 * @Author: wangchangyong
 * @Date: 2021/2/23 21:47
 * @Version: 1.0.0
 **/
public class _003_LengthOfLongestSubstring {

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(字符集)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 窗口右移重复字符后面一位
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            // 字符 和 下标 存入哈希表
            map.put(s.charAt(i), i);
            // 计算最大长度
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
