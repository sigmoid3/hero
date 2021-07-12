package utils;

/**
 * @Author: sandro
 * @Create: 2019-09-05
 * @Description:
 **/
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left = null;
    public TreeLinkNode right = null;
    public TreeLinkNode next = null; //指向父节点
    public TreeLinkNode(int val) {
        this.val = val;
    }
}