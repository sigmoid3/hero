package finger2offer.tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class PrintZhi {
	public ArrayList<ArrayList<Integer>> printZhi(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (pRoot == null) {
			return res;
		}
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<TreeNode> q = new LinkedList<>();
		q.addLast(null);
		q.addLast(pRoot);

		boolean leftToRight = true;

		while (q.size() != 1) {
			TreeNode node = q.removeFirst();
			if (node == null) {
				Iterator<TreeNode> it = null;
				if (leftToRight) {
					it = q.iterator();
				} else {
					it = q.descendingIterator();
				}
				leftToRight = !leftToRight;
				while (it.hasNext()) {
					TreeNode tmp = it.next();
					list.add(tmp.val);
				}
				res.add(new ArrayList<Integer>(list));
				list.clear();
				q.addLast(null);
				continue;
			}
			if (node.left != null) {
				q.addLast(node.left);
			}
			if (node.right != null) {
				q.addLast(node.right);
			}
		}
		return res;
	}
}
