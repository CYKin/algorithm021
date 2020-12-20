import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _105_BuildTree
 * @Description: 105. 从前序与中序遍历序列构造二叉树
 * @Author: wangchangyong
 * @Date: 2020/12/19 17:09
 * @Version: 1.0.0
 **/
public class _105_BuildTree {

    /**
     * 递归
     * 时间复杂度：O(n*log(n))
     * 空间复杂度：O(n)
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildSubTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    /**
     * 构造子树
     * @param preorder 前序遍历数组
     * @param pStart   前序遍历开始位置
     * @param pEnd     前序遍历结束位置
     * @param inorder  中序遍历
     * @param iStart   中序遍历开始位置
     * @param iEnd     中序遍历结束位置
     * @param map      中序遍历索引位置
     * @return
     */
    private TreeNode buildSubTree(int[] preorder, int pStart, int pEnd,
                                  int[] inorder, int iStart, int iEnd,
                                  Map<Integer, Integer> map) {
        // 结束条件
        if (pStart == pEnd + 1) {
            return null;
        }
        // 前序遍历第一个节点为根节点
        int rootVal = preorder[pStart];
        // 根节点
        TreeNode root = new TreeNode(rootVal);
        int index = map.get(rootVal);

        // 左子树元素个数
        int leftNum = index - iStart;

        // 下层递归
        root.left = buildSubTree(preorder, pStart + 1, pStart + leftNum, inorder, iStart, index - 1, map);
        root.right = buildSubTree(preorder, pStart + leftNum + 1, pEnd, inorder, index + 1, iEnd, map);
        return root;
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
