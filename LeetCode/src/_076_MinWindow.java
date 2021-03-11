import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _076_MinWindow
 * @Description: 76. 最小覆盖子串
 * @Author: wangchangyong
 * @Date: 2021/2/23 22:03
 * @Version: 1.0.0
 **/
public class _076_MinWindow {

    /**
     * 滑动窗口 + 哈希表
     * 时间复杂度：O(n) n = s.length()
     * 空间复杂度：O(m) m = t.length()
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        // 最小字符串左下标
        int minLeft = 0;
        // 最小字符串长度
        int minLen = s.length();
        // 包含字符长度
        int count = t.length();
        // 是否存在最小覆盖子串
        boolean isExist = false;

        // 统计t字符串中字符出现次数 用于判断s字符串需要覆盖的字符
        Map<Character, Integer> map = new HashMap<>(count);
        for (int i = 0; i < count; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        // 覆盖子串左下标
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // t中包含字符，字符出现次数减一，总字符数减一
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0) {
                    count--;
                }
            }

            // 子串字符全部覆盖t中字符
            while (count == 0 && left <= right) {
                isExist = true;
                int len = right - left + 1;
                // 获取当前最小覆盖字符串
                if (len < minLen) {
                    minLen = len;
                    minLeft = left;
                }

                // 左下标右移，字符出现次数加一，总字符数加一
                if (map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if (map.get(s.charAt(left)) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        return isExist == true ? s.substring(minLeft, minLeft + minLen) : "";
    }
}
