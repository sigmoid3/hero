package finger2offer.tree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        q.add(root);
        int cnt;
        while (!q.isEmpty()) {
            cnt = q.size();
            while (cnt-- > 0) {
                TreeNode t = q.poll();
                if (t == null) {
                    continue;
                }
                res.add(t.val);
                q.add(t.left);
                q.add(t.right);
            }
        }
        return res;
    }
}