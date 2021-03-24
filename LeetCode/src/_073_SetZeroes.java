import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: _073_SetZeroes
 * @Description: 73. 矩阵置零
 * @Author: wangchangyong
 * @Date: 2021/3/21 18:04
 * @Version: 1.0.0
 **/
public class _073_SetZeroes {

    /**
     * 标记0出现的行和列，再置为0
     * 时间复杂度：O(mn)
     * 空间复杂度：O(m+n-1)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        Set<Integer> row_zero = new HashSet<>();
        Set<Integer> col_zero = new HashSet<>();

        // 记录出现过0的行和列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    row_zero.add(i);
                    col_zero.add(j);
                }
            }
        }

        // 出现0的行和列全部置0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (row_zero.contains(i) || row_zero.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

}
