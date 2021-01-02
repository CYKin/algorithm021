import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _290_WordPattern
 * @Description: 290. 单词规律
 * @Author: wangchangyong
 * @Date: 2020/12/17 21:51
 * @Version: 1.0.0
 **/
public class _290_WordPattern {

    /**
     * 哈希表
     * 字符与单词映射关系通过数组下标是否相同来判断
     * @param pattern
     * @param str
     * @return
     */
    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map<Character, Integer> charMap = new HashMap<>();
        Map<String, Integer> strMap = new HashMap<>();
        for (Integer i = 0; i < words.length; i++) {
            Integer m = charMap.put(pattern.charAt(i), i);
            Integer n = strMap.put(words[i], i);
            if (m != n) {
                return false;
            }
        }
        return true;
    }
}
