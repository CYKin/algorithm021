/**
 * @ClassName: _jz_22_GetKthFromEnd
 * @Description: 剑指 Offer 22. 链表中倒数第k个节点
 * @Author: wangchangyong
 * @Date: 2021/2/24 21:40
 * @Version: 1.0.0
 **/
public class _jz_22_GetKthFromEnd {

    /**
     * 快慢指针
     * 设有两个指针p和q，初始时均指向头结点
     * 首先，先让p沿着next移动k次。此时，p指向第k+1个结点，q指向头节点，两个指针的距离为k
     * 然后，同时移动p和q，直到p指向空，此时q即指向倒数第k个结点
     * 时间复杂度：
     * 空间复杂度：
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
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
