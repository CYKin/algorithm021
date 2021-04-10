/**
 * @ClassName: _074_SearchMatrix
 * @Description: 74. 搜索二维矩阵
 * @Author: wangchangyong
 * @Date: 2021/3/30 21:51
 * @Version: 1.0.0
 **/
public class _074_SearchMatrix {

    /**
     * 将二维数组看做一个升序数组，采用二分查找思路
     * 时间复杂度：O(log(mn))
     * 空间复杂度：O(1)
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        // 二分查找
        int i = 0, j = row * col - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            int midValue = matrix[mid / col][mid % col];
            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
}
