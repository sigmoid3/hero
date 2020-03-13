package finger2offer.link;

import utils.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class ReverseList {

    //栈方法，只读打印
    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while (!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
    }

    //递归方法，只读打印
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead3(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    //头插法，结构改变
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        ListNode prev = null;
        while (listNode != null) {
            ListNode tmp = listNode.next;
            listNode.next = prev;
            prev = listNode;
            listNode = tmp;
        }
        while (prev != null) {
            ret.add(prev.val);
            prev = prev.next;
        }
        return ret;
    }

    //倒置法，结构改变
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        while (listNode != null) {
            ret.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(ret);
        return ret;
    }

}


