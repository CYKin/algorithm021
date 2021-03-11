/**
 * @ClassName: _876_MiddleNode
 * @Description: 876. 链表的中间结点
 * @Author: wangchangyong
 * @Date: 2021/2/24 21:55
 * @Version: 1.0.0
 **/
public class _876_MiddleNode {

    /**
     * 快慢指针
     * 两个指针fast和slow，初始时指向头节点
     * 每次移动时，fast向后走两次，slow向后走一次，fast 和 slow 的距离就会增加一
     * 设链表有 n 个元素，那么最多移动 n/2 轮。当 n 为奇数时，slow 恰好指向中间结点，当 n 为 偶数时，slow 恰好指向中间两个结点的靠前一个
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
