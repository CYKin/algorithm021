import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _050_MyPow
 * @Description: 50. Pow(x, n)
 * @Author: wangchangyong
 * @Date: 2020/12/15 22:34
 * @Version: 1.0.0
 **/
public class _050_MyPow {

    /**
     * 分治
     * 时间复杂度：O(logn)
     * 空间复杂度：O(logn)
     * 2^10 = 2^5 * 2^5
     * 2^5 = 2 * 2^2 * 2^2
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long k = n;
        if (k < 0) {
            k = -k;
            x = 1 / x;
        }
        return pow(x, k);
    }

    public double pow(double x, long k) {
        if (k == 0) {
            return 1;
        }
        return (k % 2 == 0) ? pow(x * x, k / 2) : x * pow(x * x, k / 2);
    }

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

}
