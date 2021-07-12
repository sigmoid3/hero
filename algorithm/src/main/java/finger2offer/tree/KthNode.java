package finger2offer.tree;

import utils.TreeNode;

import java.util.Stack;

public class KthNode {
    TreeNode kthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0)
            return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int cnt = 0;
        TreeNode node = pRoot;
        do {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                cnt++;
                if (cnt == k)
                    return node;
                node = node.right;
            }
        } while (node != null || !stack.isEmpty());
        return null;
    }
}