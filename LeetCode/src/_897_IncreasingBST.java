import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: _897_IncreasingBST
 * @Description: 897. 递增顺序搜索树
 * @Author: wangchangyong
 * @Date: 2021/4/25 21:52
 * @Version: 1.0.0
 **/
public class _897_IncreasingBST {

    /**
     * DFS
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode();
        TreeNode node = head;

        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            node.right = root;
            node = root;

            root = root.right;
        }
        return head.right;
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
