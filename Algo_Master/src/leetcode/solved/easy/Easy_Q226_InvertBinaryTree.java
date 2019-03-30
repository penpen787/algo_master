package leetcode.solved.easy;


import leetcode.TreeNode;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class Easy_Q226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        TreeNode node = null;
        if(root != null) {
            node = new TreeNode(0);
            trav(root, node);
        }
        return node;
    }

    public void trav(TreeNode org, TreeNode copy) {
        copy.val = org.val;
        if(org.left != null) {
            copy.right = new TreeNode(0);
            trav(org.left, copy.right);
        }
        if(org.right != null) {
            copy.left = new TreeNode(0);
            trav(org.right, copy.left);
        }
    }
}
