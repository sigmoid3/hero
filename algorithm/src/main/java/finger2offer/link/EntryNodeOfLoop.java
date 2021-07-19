package finger2offer.link;

import utils.ListNode;

public class EntryNodeOfLoop {

    public ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        int stepSlow = 0;
        //check the pointer is valid
        if (slow.next == null) {
            return null;
        }
        //check the pointer for two e-loop
        if (fast.next.next == null && fast.next == slow) {
            return pHead;
        }
        //calculate the length of loop
        while (fast.next.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = fast.next;
        int stepFast = 1;
        while (fast != slow) {
            fast = fast.next;
            stepFast++;
        }
        //check the single loop
        if (fast == pHead) {
            return pHead;
        }
        //to find the entrynode with fast and slow pointer
        ListNode tmp = pHead;
        for (int i = 0; i < stepFast; i++) {
            tmp = tmp.next;
        }
        while (tmp != null && pHead != null) {
            tmp = tmp.next;
            pHead = pHead.next;
            if (tmp == pHead) {
                break;
            }
        }
        return pHead;
    }
}