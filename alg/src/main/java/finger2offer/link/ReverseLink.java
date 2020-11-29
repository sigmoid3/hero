package finger2offer.link;

import utils.ListNode;

public class ReverseLink {
    public static ListNode reverseLink(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        ListNode pre = null;
        ListNode tmp = null;
        ListNode reversed = null;
        while (current != null) {
            //指针域变换
            tmp = current.next;
            current.next = pre;
            //判断是否为尾节点
            if (tmp == null) {
                reversed = current;
            }
            //节点变换
            pre = current;
            current = tmp;
        }
        return reversed;
    }
}