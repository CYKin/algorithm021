/**
 * @ClassName: _142_DetectCycle
 * @Description: 142. 环形链表 II
 * @Author: wangchangyong
 * @Date: 2021/2/25 21:41
 * @Version: 1.0.0
 **/
public class _142_DetectCycle {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // 判断是否存在圆环
        boolean isCycle = false;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isCycle = true;
                break;
            }
        }

        // 存在圆环，fast指向头结点 当fast和slow相遇则是圆环入口
        if (isCycle) {
            fast = head;
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
        return null;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
