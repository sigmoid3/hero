package algorithm.link;

import utils.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q)
                return true;
        }
        return false;
    }
}