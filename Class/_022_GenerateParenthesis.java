import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _022_GenerateParenthesis
 * @Description: 22. 括号生成
 * @Author: wangchangyong
 * @Date: 2020/12/14 22:04
 * @Version: 1.0.0
 **/
public class _022_GenerateParenthesis {

    /**
     * 递归
     * 时间复杂度：O(2^n)
     * 空间复杂度：
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generater(0, 0, n, "", list);
        return list;
    }

    public void generater(int left, int right, int n, String s, List<String> list) {
        // 递归终结条件
        if (left == n && right == n) {
            list.add(s);
            return;
        }

        // 处理当前层逻辑 递归下一层 有效括号判断
        if (left < n) {
            generater(left + 1, right, n, s + "（", list);
        }
        if (left > right) {
            generater(left, right + 1, n, s + ")", list);
        }
    }
}
