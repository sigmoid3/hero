package old.link;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLink {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;       //前置空節點
        while(head!=null){
            ListNode tmp = head.next;   //建暫存節點
            head.next = prev;   // 指針倒置
            prev = head;    // head.next 值改變
            head = tmp;     // head值改變
        }
        return prev;    // 返回新的頭節點
    }

    //栈方法
    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();   
        while(listNode!=null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while(!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }

    //递归方法
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(listNode!=null){
            ret.addAll(printListFromTailToHead2(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    //头插法
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        ListNode head = new ListNode(-1);
        while(listNode!=null){
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        head = head.next;
        while(head!=null){
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    //倒置法
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        while(listNode!=null){
            ret.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(ret);
        return ret;
    }

}


