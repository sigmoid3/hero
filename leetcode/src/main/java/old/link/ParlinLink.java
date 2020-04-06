package old.link;

import utils.ListNode;

public class ParlinLink {

    ListNode reverseList(ListNode head) {
        ListNode prev = null; // 链表原地反转
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev; // 入度方向改变
            prev = head;
            head = temp;
        }
        return prev;
    }

    ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) // 找到链表中点
            return head;

        ListNode p = head, q = head;
        while (q != null && q.next != null) { // 前指针进1，后指针进2，故只要后指针不为空，则p最后所处的位置就是中点
            p = p.next;
            q = q.next.next;
        }

        return p;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode middle = findMiddle(head);
        middle.next = reverseList(middle.next);

        ListNode p = head, q = middle.next;
        while (p != null & q != null && p.val == q.val) {
            p = p.next;
            q = q.next;
        }
        return q == null;

    }
}