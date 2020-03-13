package finger2offer.tree;

import utils.TreeNode;

public class Serialize {
    public int idx = -1;

    String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    TreeNode deSerialize(String str) {
        idx++;
        int len = str.length();
        if (idx >= len) {
            return null;
        }
        String[] strArr = str.split(",");
        TreeNode node = null;
        if (!strArr[idx].equals("#")) {
            node = new TreeNode(Integer.valueOf(strArr[idx]));
            node.left = deSerialize(str);
            node.right = deSerialize(str);
        }

        return node;
    }
}