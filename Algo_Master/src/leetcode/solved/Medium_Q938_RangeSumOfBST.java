package leetcode.solved;

import leetcode.TreeNode;

/**
 * https://leetcode.com/problems/range-sum-of-bst
 */
public class Medium_Q938_RangeSumOfBST {

    int L,R,sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        this.L = L;
        this.R = R;
        checkAndSum(root);
        return sum;
    }

    public void checkAndSum(TreeNode n) {
        if(n == null) return;
        if(n.val >= L && n.val <= this.R) sum += n.val;

        if(n.left != null && n.val >= this.L) checkAndSum(n.left);
        if(n.right != null && n.val <= this.R) checkAndSum(n.right);
    }
}
