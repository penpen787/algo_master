package leetcode.solved.medium;

import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class Medium_Q102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root != null) addNode(root, 0);
        return list;
    }

    private void addNode(TreeNode n, int level) { // level is zero-based
        if(level > list.size()-1)  // need to add a new level node list
            list.add(new ArrayList<Integer>());

        list.get(level).add(n.val);

        if(n.left != null) addNode(n.left, level+1);
        if(n.right != null) addNode(n.right, level+1);
    }
}
