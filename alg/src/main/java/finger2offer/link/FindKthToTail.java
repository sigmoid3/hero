package finger2offer.link;

import utils.ListNode;

public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head, int k) {
        //to check the safety of code
        if (head == null || k < 1) {
            return null;
        }
        int idx = 0;
        ListNode tmp = head;
        ListNode cnt = head;
        while (idx < k - 1) {
            //to check the safety of code
            if (tmp.next == null) {
                return null;
            } else {
                tmp = tmp.next;
            }
            idx++;
        }
        //to check the safety of code
        while (tmp.next != null) {
            tmp = tmp.next;
            head = head.next;
        }
        return head;
    }
}