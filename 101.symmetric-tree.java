import java.util.LinkedList;
import java.util.Queue;
/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()) {
            TreeNode nodeRight = q.poll();
            TreeNode nodeLeft = q.poll();
            if (nodeRight == null && nodeLeft == null) continue;
            if (nodeRight == null || nodeLeft == null || nodeRight.val != nodeLeft.val) return false;
            q.add(nodeLeft.left);
            q.add(nodeRight.right);
            q.add(nodeLeft.right);
            q.add(nodeRight.left);
        }
        return true;
    }
}
// @lc code=end

