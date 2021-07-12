package finger2offer.tree;

import utils.TreeLinkNode;

public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            //若存在右子树，那么是右子树的最左节点
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            //若不存在右子树，那么是第一个左子树包含该节点的祖先节点
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                //向上寻找包含该子树的祖先
                pNode = pNode.next;
            }
        }
        return null;
    }
}