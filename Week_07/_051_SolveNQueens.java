import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _51_SolveNQueens
 * @Description: 51. N 皇后
 * @Author: wangchangyong
 * @Date: 2021/1/16 17:36
 * @Version: 1.0.0
 **/
public class _051_SolveNQueens {

    /**
     * BFS + 回溯
     * 时间复杂度：O(n*n*logn)
     * 空间复杂度：O(n*n)
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        bfs(chess, 0, result);
        return result;
    }

    public void bfs(char[][] chess, int row, List<List<String>> result) {
        // 终止条件
        if (row == chess.length) {
            // 将棋盘转换成结果返回
            result.add(constrcut(chess));
            return;
        }

        // 每一列放置皇后
        for (int col = 0; col < chess.length; col++) {
            // 放置是否有效
            if (valid(chess, row, col)) {
                // 放置皇后
                chess[row][col] = 'Q';
                // 下一行放置皇后
                bfs(chess, row + 1, result);
                // 回溯 chess[row][col]放置皇后后，还原不要影响下一列
                chess[row][col] = '.';
            }
        }
    }

    public List<String> constrcut(char[][] chess) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            list.add(new String(chess[i]));
        }
        return list;
    }

    /**
     * 校验char[row][col]放置皇后是否有效
     * 检测：行、列、对角是否有效
     * @param chess
     * @param row
     * @param col
     * @return
     */
    public boolean valid(char[][] chess, int row, int col) {

        // 行：当前行需要找位置放置皇后，可以不校验
        // 列：从0 -> row行这一列是否放置皇后
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        // 左上角是否放置皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        // 右上角是否放置皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

}
