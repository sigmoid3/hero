package old.tree;

import utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ReconstructTree {

    private Map<Integer, Integer> indexForOrder = new HashMap<>();

    public TreeNode reConstruct(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForOrder.put(in[i], i);
        }
        return reConstruct(pre, 0, pre.length - 1, 0);
    }

    private TreeNode reConstruct(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int inIndex = indexForOrder.get(root.val);
        int leftTreeSize = inIndex - inL;
        root.left = reConstruct(pre, preL + 1, preL + leftTreeSize, inL);
        System.out.printf("%s %s", root.left, root.right);
        System.out.println();
        root.right = reConstruct(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }

    // abc
    // import the preorder and inorder
    public TreeNode reConstructBinaryTree2(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree2(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree2(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) { return null; }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree2(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree2(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ReconstructTree reconstructTree = new ReconstructTree();
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        System.out.println(reconstructTree.reConstruct(pre, in));
    }
}