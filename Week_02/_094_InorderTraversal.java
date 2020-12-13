import java.util.*;

/**
 * @ClassName: _094_InorderTraversal
 * @Description: 94. 二叉树的中序遍历
 * @Author: wangchangyong
 * @Date: 2020/12/9 16:20
 * @Version: 1.0.0
 **/
public class _094_InorderTraversal {

    /**
     * 递归遍历
     * 二叉树中序：左 - 根 - 右
     * 时间复杂度：O(n)
     * 空间复杂度：O(n) 递归栈的深度
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // 每个节点看做一个循环体
        inorder(root, list);
        return list;
    }

    /**
     * 栈遍历
     * 二叉树中序：左 - 根 - 右
     * 时间复杂度：O(n)
     * 空间复杂度：O(n) 递归栈的深度
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        while (root != null || !stk.isEmpty()) {
            // 从根节点到最左节点全部压入栈中
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            // 获取栈顶节点，即最左节点
            root = stk.pop();
            list.add(root.val);
            // 遍历右节点
            root = root.right;
        }
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
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
