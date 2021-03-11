import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: _429_LevelOrder
 * @Description: TODO
 * @Author: wangchangyong
 * @Date: 2020/12/10 15:23
 * @Version: 1.0.0
 **/
public class _429_LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Node> stk = new ArrayDeque<>();

        if (root == null) {
            return result;
        }
        stk.offer(root);

        while (!stk.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = stk.size();
            for (int i = 0; i < size; i++) {
                Node poll = stk.poll();
                list.add(poll.val);
                stk.addAll(poll.children);
            }
            result.add(list);
        }
        return result;
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
