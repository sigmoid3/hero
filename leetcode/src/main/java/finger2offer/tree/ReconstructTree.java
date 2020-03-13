package finger2offer.tree;

import utils.TreeNode;

public class ReconstructTree {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                //左子树，前序遍历和中序遍历的起始位置和结束位置
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre - startIn + i, in, startIn, i - 1);
                //右子树
                root.right = reConstructBinaryTree(pre, startPre - startIn + i + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }
}