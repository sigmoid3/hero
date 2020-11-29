package finger2offer.tree;

import utils.TreeNode;

public class TreeConvertLink {

    TreeNode head = null;
    TreeNode real = null;


    public TreeNode treeConvertLink(TreeNode pRootOfTree) {
        Convert(pRootOfTree);
        return real;
    }

    private void Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null)
            return;
        Convert(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            real = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        Convert(pRootOfTree.right);
    }
}