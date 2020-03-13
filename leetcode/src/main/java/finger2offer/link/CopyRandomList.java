package finger2offer.link;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class CopyRandomList {
    public RandomListNode Clone1(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode currentNode = pHead;

        //时间复杂度为O(n),不需要辅助空间
        // 1、复制每个结点，如复制结点A得到A'，将结点A'插到结点A后面；
        while (currentNode != null) {
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }
        currentNode = pHead;

        // 2、重新遍历链表，复制老结点的随机指针给新结点，如A'.random = A.random.next;
        while (currentNode != null) {
            currentNode.next.random = currentNode.random == null ? null : currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        // 3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next == null ? null : cloneNode.next.next;
            currentNode = currentNode.next;
        }
        return pCloneHead;
    }

    //时间复杂度为O(1),空间复杂度为O(n)
    public RandomListNode Clone2(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode p = pHead;
        RandomListNode q = new RandomListNode(-1);
        while (p != null) {
            RandomListNode t = new RandomListNode(p.label);
            map.put(p, t);
            p = p.next;
            q.next = t;
            q = t;
        }
        Set<Entry<RandomListNode, RandomListNode>> set = map.entrySet();
        Iterator<Entry<RandomListNode, RandomListNode>> it = set.iterator();
        while (it.hasNext()) {
            Entry<RandomListNode, RandomListNode> next = it.next();
            next.getValue().random = map.get(next.getKey().random);
        }
        return map.get(pHead);
    }
}