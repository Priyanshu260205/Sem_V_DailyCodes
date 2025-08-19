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
    int max_diff;
    public int maxAncestorDiff(TreeNode root) {
        max_diff = 0;
        if(root == null){
            return max_diff;
        }
        helper(root, root.val, root.val);
        return max_diff;
    }
    private void helper(TreeNode root, int curr_max, int curr_min){
        if(root != null){
            int curr_diff = Math.max(Math.abs(root.val - curr_max), Math.abs(root.val - curr_min));
            max_diff = Math.max(max_diff, curr_diff);
            curr_max = Math.max(curr_max, root.val);
            curr_min = Math.min(curr_min, root.val);
            helper(root.left, curr_max, curr_min);
            helper(root.right, curr_max, curr_min);
        }
    }
}