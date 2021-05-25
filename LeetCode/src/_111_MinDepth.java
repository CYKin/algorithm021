import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _111_MinDepth
 * @Description: 111. 二叉树的最小深度
 * @Author: wangchangyong
 * @Date: 2021/4/22 22:57
 * @Version: 1.0.0
 **/
public class _111_MinDepth {

    /**
     * DFS
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param root
     * @return
     */
    public int minDepthDp(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepthDp(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepthDp(root.right), minDepth);
        }
        return minDepth + 1;
    }

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        return (leftDepth == 0 || rightDepth == 0) ? Math.max(leftDepth, rightDepth) + 1 : Math.min(leftDepth, rightDepth) + 1;

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
