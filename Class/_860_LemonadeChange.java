import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _860_LemonadeChange
 * @Description: 860. 柠檬水找零
 * @Author: wangchangyong
 * @Date: 2020/12/10 13:38
 * @Version: 1.0.0
 **/
public class _860_LemonadeChange {

    /**
     * 贪心算法
     * 时间复杂度：O(n)
     * 空进复杂度：O(1)
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5) five++;
            else if (i == 10) {five--; ten++;}
            else if (ten > 0) {ten--; five--;}
            else five -= 3;
            if (five < 0) return false;
        }
        return true;
    }

}
