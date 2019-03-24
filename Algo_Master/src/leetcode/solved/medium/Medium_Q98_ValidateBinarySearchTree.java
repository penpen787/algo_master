package leetcode.solved.medium;

import leetcode.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree
 * assuming the value is between Integer range
 */
public class Medium_Q98_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidNode(TreeNode n, long min, long max) {
        if(n == null) return true; // null tree is allowed

        if(n.val <= min || n.val >= max) return false;

        return isValidNode(n.left, min, n.val) && isValidNode(n.right, n.val, max);
    }
}
