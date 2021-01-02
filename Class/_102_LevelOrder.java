import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: _102_LevelOrder
 * @Description: 102. 二叉树的层序遍历
 * @Author: wangchangyong
 * @Date: 2020/12/21 21:10
 * @Version: 1.0.0
 **/
public class _102_LevelOrder {

    /**
     * 广度优先搜索
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        stk.offer(root);

        while (!stk.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // 每一层节点个数
            int size = stk.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stk.poll();
                list.add(node.val);
                // 左右子节点入栈
                if (node.left != null) {
                    stk.add(node.left);
                }
                if (node.right != null) {
                    stk.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
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
