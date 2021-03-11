import java.util.*;

/**
 * @ClassName: _236_LowestCommonAncestor
 * @Description: 236. 二叉树的最近公共祖先
 * @Author: wangchangyong
 * @Date: 2020/12/19 15:33
 * @Version: 1.0.0
 **/
public class _236_LowestCommonAncestor {

    /**
     * 树
     * 查找p、q的父节点，第一次出现相同的节点就是最近公共祖先
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 获取节点父节点关系
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        dfs(root, parentMap);

        Set<Integer> set = new HashSet<>();
        // 获取p的父节点
        while (p != null) {
            set.add(p.val);
            p = parentMap.get(p.val);
        }

        // 获取q的父节点, 第一个p相同节点就是最近公共祖先
        while (q != null) {
            if (set.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }
        return null;
    }

    /**
     * 递归获取每个节点的父节点关系
     * @param root
     * @param parentMap
     */
    public void dfs(TreeNode root, Map<Integer, TreeNode> parentMap) {
        // 左节点
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            dfs(root.left, parentMap);
        }
        // 右节点
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            dfs(root.right, parentMap);
        }
    }


    /**
     * 节点定义
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
