import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _387_FirstUniqChar
 * @Description: 387. 字符串中的第一个唯一字符
 * @Author: wangchangyong
 * @Date: 2021/2/23 21:22
 * @Version: 1.0.0
 **/
public class _387_FirstUniqChar {

    /**
     * 数组存储字符出现频次
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 哈希表存储字符出现频次
     * 时间复杂度：O(n)
     * 空间复杂度：O(字符集)
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
