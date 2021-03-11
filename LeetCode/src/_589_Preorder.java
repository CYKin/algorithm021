import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: _589_Preorder
 * @Description: 589. N叉树的前序遍历
 * @Author: wangchangyong
 * @Date: 2020/12/10 14:36
 * @Version: 1.0.0
 **/
public class _589_Preorder {

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    /**
     * 迭代 栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        Deque<Node> stk = new ArrayDeque<>();

        if (root == null) {
            return list;
        }
        stk.push(root);

        while (!stk.isEmpty()) {
            root = stk.pop();
            list.add(root.val);
            // 子节点从右到左人栈
            for (int i = root.children.size() - 1; i >= 0; i--) {
                stk.push(root.children.get(i));
            }
        }
        return list;
    }

    public void inorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        for (Node childrenNode : node.children) {
            inorder(childrenNode, list);
        }
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
