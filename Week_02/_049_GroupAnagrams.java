import java.util.*;

/**
 * @ClassName: _049_GroupAnagrams
 * @Description: 49. 字母异位词分组
 * @Author: wangchangyong
 * @Date: 2020/12/7 22:02
 * @Version: 1.0.0
 **/
public class _049_GroupAnagrams {

    /**
     * 字符串 + 哈希表
     * 时间复杂度：时间复杂度：O(NKlogK)，其中N是strs的长度，而K是strs中字符串的最大长度
     * 空间复杂度：O(NK)，排序存储在map中的全部信息内容
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }

}
