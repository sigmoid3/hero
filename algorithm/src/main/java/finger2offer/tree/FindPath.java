package finger2offer.tree;

import utils.TreeNode;

import java.util.ArrayList;

/*
 *  输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target -= root.val;
        // 叶节点满足条件
        if (target == 0 && root.left == null && root.right == null) {
            // 避免指向同一个list,所以必须用new
            listAll.add(new ArrayList<Integer>(list));
        }
        findPath(root.left, target);
        findPath(root.right, target);
        // dfs回退
        list.remove(list.size() - 1);
        return listAll;
    }
}
