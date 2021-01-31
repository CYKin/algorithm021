/**
 * @ClassName: _058_LengthOfLastWord
 * @Description: TODO
 * @Author: wangchangyong
 * @Date: 2021/1/26 21:43
 * @Version: 1.0.0
 **/
public class _058_LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.lastIndexOf(" ");
        if (i == -1) {
            return s.length();
        }
        return s.length() - i - 1;
    }


}
