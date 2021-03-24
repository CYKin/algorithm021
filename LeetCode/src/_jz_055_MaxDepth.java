import com.sun.source.tree.Tree;

/**
 * @ClassName: _jz_055_MaxDepth
 * @Description: 剑指Offer 55 - I.二叉树的高度
 * @Author: wangchangyong
 * @Date: 2021/3/24 14:57
 * @Version: 1.0.0
 **/
public class _jz_055_MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
