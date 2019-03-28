package leetcode.solved.easy;


import leetcode.TreeNode;

/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 */
public class Easy_Q617_MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t2 == null) {
            return t1;
        }
        if(t1 == null) {
            t1 = new TreeNode(0);
        }
        trav(t1, t2);
        return t1;
    }

    public void trav(TreeNode t1, TreeNode t2) {
        t1.val += t2.val;
        if(t2.left != null) {
            if(t1.left == null) {
                t1.left = new TreeNode(0);
            }
            trav(t1.left, t2.left);
        }
        if(t2.right != null) {
            if(t1.right == null) {
                t1.right = new TreeNode(0);
            }
            trav(t1.right, t2.right);
        }
    }
}
