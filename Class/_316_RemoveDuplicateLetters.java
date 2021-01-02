import java.util.Arrays;

/**
 * @ClassName: _316_removeDuplicateLetters
 * @Description: 316. 去除重复字母
 * @Author: wangchangyong
 * @Date: 2020/12/20 12:17
 * @Version: 1.0.0
 **/
public class _316_RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        // 不重复元素位置
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length - 1; i++) {
            if(i == 0){
                sb.append(chars[0]);
            }
            if (chars[i] != chars[i + 1]) {
                sb.append(chars[i + 1]);
            }
        }
        return sb.toString();
    }
}
