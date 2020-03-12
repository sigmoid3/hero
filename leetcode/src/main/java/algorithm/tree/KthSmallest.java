package algorithm.tree;

import utils.TreeNode;

public class KthSmallest {
	int idx = 0;

	public int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return 0;
		}
		int ret = kthSmallest(root.left, k);
		if (k == ++idx) {
			return (int)root.val;
		}
		if (k < idx) {
			return ret;
		}
		return kthSmallest(root.right, k);
	}
}