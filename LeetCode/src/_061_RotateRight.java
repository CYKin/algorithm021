/**
 * @ClassName: _061_RotateRight
 * @Description: 61. 旋转链表
 * @Author: wangchangyong
 * @Date: 2021/3/27 21:53
 * @Version: 1.0.0
 **/
public class _061_RotateRight {

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 链表长度
        int len = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            len++;
        }

        // 取余
        k = k % len;
        if (k == 0) {
            return head;
        }

        // 尾结点和首节点连接
        node.next = head;

        // 第k个节点和k+1节点断开连接, k = null newHead = k+1
        ListNode slow = head;
        for (int i = 0; i < len - k - 1; i++) {
            slow = slow.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
