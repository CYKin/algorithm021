/**
 * @ClassName: _110_isBalanced
 * @Description: 110. 平衡二叉树
 * @Author: wangchangyong
 * @Date: 2021/3/11 23:18
 * @Version: 1.0.0
 **/
public class _110_isBalanced {

    /**
     * 递归 自底向上判断二叉树高度，是平衡二叉树高度+1返回 不是平衡二叉树返回-1
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    /**
     * 返回节点子树最大高度
     * @param node
     * @return
     */
    public int height(TreeNode node) {
        if (node == null) {
            return -1;
        }

        // 左子树高度
        int left = height(node.left);
        if (left == -1) {
            return -1;
        }

        // 右子树高度
        int right = height(node.right);
        if (right == -1) {
            return -1;
        }

        // 判断是否是平衡二叉树
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;

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
