import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _144_PreorderTraversal
 * @Description: 144. 二叉树的前序遍历
 * @Author: wangchangyong
 * @Date: 2020/12/9 17:04
 * @Version: 1.0.0
 **/
public class _144_PreorderTraversal {

    /**
     * 二叉树前序：根 - 左 - 右
     * 递归遍历
     * 时间复杂度：O(n)
     * 空间复杂度：O(n) 递归栈的深度
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        inorder(root.left, list);
        inorder(root.right, list);
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
