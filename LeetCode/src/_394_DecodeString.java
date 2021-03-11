import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: _394_DecodeString
 * @Description: 394. 字符串解码
 * @Author: wangchangyong
 * @Date: 2021/2/3 21:24
 * @Version: 1.0.0
 **/
public class _394_DecodeString {

    /**
     * 栈
     * 时间复杂度：
     * 空间复杂度：
     * @param s
     * @return
     */
    public String decodeString(String s) {

        int num = 0;
        StringBuilder str = new StringBuilder();

        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // 处理数字
            if (Character.isDigit(c)) {
                // 考虑多位数
                num = num * 10 + (c - '0');
            }else if(c == '[') {
                // 左括号入栈
                numStack.push(num);
                strStack.push(str.toString());
                // 入栈后置空置0
                num = 0;
                str = new StringBuilder();
            } else if (c == ']') {
                // 右括号出栈 拼接字符串 当前出栈字符串 + str * num
                StringBuilder temp = new StringBuilder();
                int stackNum = numStack.removeFirst();
                for (int i = 0; i < stackNum; i++) {
                    temp.append(str);
                }
                str = new StringBuilder(strStack.removeFirst()).append(temp);
            } else {
                // 字符直接append
                str.append(c);
            }
        }
        return str.toString();
    }
}
