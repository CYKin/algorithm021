/**
 * @ClassName: _344_ReverseString
 * @Description: 344. 反转字符串
 * @Author: wangchangyong
 * @Date: 2021/1/26 21:52
 * @Version: 1.0.0
 **/
public class _344_ReverseString {

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

}
