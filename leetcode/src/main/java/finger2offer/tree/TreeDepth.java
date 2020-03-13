package finger2offer.tree;

import utils.TreeNode;

public class TreeDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        treeDepth(root);
    }

    private static int treeDepth(TreeNode root) {
        return root == null ? 0 : Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
    }
}