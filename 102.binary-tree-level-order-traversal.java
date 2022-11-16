import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> innerList = new ArrayList<Integer>();

        if (root == null) return res;

        innerList.add(root.val);
        res.add(innerList);
        if (root.left == null && root.right == null) return res;

        Queue<TreeNode> s = new LinkedList<TreeNode>();
        if (root.left != null) s.add(root.left);
        if (root.right != null) s.add(root.right);
        int len = s.size();
        innerList = new ArrayList<Integer>();
        while(len > 0) {
            TreeNode node = s.poll();
            innerList.add(node.val);
            if (node.left != null) s.add(node.left);
            if (node.right != null) s.add(node.right);
            len--;

            if (len == 0) {
                res.add(innerList);
                innerList = new ArrayList<Integer>();
                len = s.size();
            }
        }

        return res;
    }
}
// @lc code=end

