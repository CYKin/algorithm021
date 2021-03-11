/**
 * @ClassName: _024_SwapPairs
 * @Description: 24. 两两交换链表中的节点
 * @Author: wangchangyong
 * @Date: 2021/2/27 21:30
 * @Version: 1.0.0
 **/
public class _024_SwapPairs {

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newNode = head.next;
        head.next = swapPairs(head.next.next);
        newNode.next = head;
        return newNode;
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
