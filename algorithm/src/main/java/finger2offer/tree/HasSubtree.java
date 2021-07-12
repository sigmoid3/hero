package finger2offer.tree;

import utils.TreeNode;

public class HasSubtree {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = method(root1, root2);
            }
            if (!result) {
                result = method(root1.left, root2);
            }
            if (!result) {
                result = method(root1.right, root2);
            }
        }
        return result;
    }

    public boolean method(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        if (root1.val != root2
                .val) {
            return false;
        }
        return method(root1.left, root2.left) && method(root1.right, root2.right);
    }
}