import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _242_IsAnagram
 * @Description: 242. 有效的字母异位词
 * 字母异位词指字母相同，但排列不同的字符串
 * @Author: wangchangyong
 * @Date: 2020/12/7 21:31
 * @Version: 1.0.0
 **/
public class _242_IsAnagram {

    /**
     * 排序 + 哈希表
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        // 排序 时间复杂度：O(nlogn)  空间复杂度：O(logn)
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        Arrays.sort(charS);
        Arrays.sort(charT);
        return Arrays.equals(charS, charT);

        // 哈希表 统计字母个数
        // 时间复杂度：O(n)，其中n为s的长度
        // 空间复杂度：O(S)，其中S为字符集大小，此处S=26
        // Map<Character, Integer> map = new HashMap<>();
        // char[] charS = s.toCharArray();
        // char[] charT = t.toCharArray();
        // // s中出现字母 +1
        // for (char sChar : charS) {
        //     if (map.containsKey(sChar)) {
        //         map.put(sChar, map.get(sChar) + 1);
        //     } else {
        //         map.put(sChar, 1);
        //     }
        // }
        // // t中出现字母 -1，为0则删除
        // for (char tChar : charT) {
        //     if (map.containsKey(tChar)) {
        //         if (map.get(tChar) - 1 == 0) {
        //             map.remove(tChar);
        //         } else {
        //             map.put(tChar, map.get(tChar) - 1);
        //         }
        //     } else {
        //         map.put(tChar, 1);
        //     }
        // }
        // return map.isEmpty();
    }
}
