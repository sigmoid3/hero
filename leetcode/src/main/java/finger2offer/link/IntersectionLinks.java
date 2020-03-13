package finger2offer.link;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class IntersectionLinks {

    public static ListNode intersectionLinks1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        if (headA == headB) {
            return headA;
        }
        ListNode originB = headB;
        while (headA != null) {
            while (headB != null) {
                if (headA.val == headB.val) {
                    return headA;
                }
                headB = headB.next;
            }
            headA = headA.next;
            headB = originB;
        }
        return null;
    }

    public static ListNode intersectionLinks2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        if (headA == headB) {
            return headA;
        }
        ListNode originB = headB;
        ListNode originA = headA;
        int lenA = 0;
        int lenB = 0;
        while (headA != null) {
            headA = headA.next;
            lenA++;
        }
        while (headB != null) {
            headB = headB.next;
            lenB++;
        }
        int len = lenA < lenB ? (lenB - lenA) : (lenA - lenB);
        headA = originA;
        headB = originB;
        if (len > 0) {
            if (lenA > lenB) {
                for (int i = 0; i < len; i++) {
                    headA = headA.next;
                }
            } else {
                for (int i = 0; i < len; i++) {
                    headB = headB.next;
                }
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}