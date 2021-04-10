/**
 * @ClassName: _002_AddTwoNumbers
 * @Description: TODO
 * @Author: wangchangyong
 * @Date: 2021/4/10 21:59
 * @Version: 1.0.0
 **/
public class _002_AddTwoNumbers {

    /**
     * 链表
     * 时间复杂度：O(max(m,n))
     * 空间复杂度：O(1)
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode node = head;
        int sum = 0;
        while (l1 != null || l2 != null) {
            sum /= 10;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            ListNode newNode = new ListNode(sum % 10);
            node.next = newNode;
            node = newNode;
        }
        // 最后一位是否进位
        if (sum / 10 > 0) {
            node.next = new ListNode(1);
        }
        return head.next;
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
