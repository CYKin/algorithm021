/**
 * @ClassName: _104_MaxDepth
 * @Description: 104. 二叉树的最大深度
 * @Author: wangchangyong
 * @Date: 2021/4/22 22:19
 * @Version: 1.0.0
 **/
public class _104_MaxDepth {

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
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
