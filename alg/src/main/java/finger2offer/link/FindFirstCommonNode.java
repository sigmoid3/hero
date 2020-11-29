package finger2offer.link;

import utils.ListNode;

public class FindFirstCommonNode {

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode tmp1 = pHead1;
        ListNode tmp2 = pHead2;
        int l;
        if (calLen(tmp1) > calLen(tmp2)) {
            l = calLen(tmp1) - calLen(tmp2);
            while (l > 0) {
                pHead1 = pHead1.next;
                l--;
            }
        } else {
            l = calLen(tmp2) - calLen(tmp2);
            while (l > 0) {
                pHead2 = pHead2.next;
                l--;
            }
        }
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        ListNode ret = pHead1;
        return ret;
    }

    public int calLen(ListNode pHead) {
        int res = 0;
        while (pHead != null) {
            pHead = pHead.next;
            res++;
        }
        return res;
    }
}