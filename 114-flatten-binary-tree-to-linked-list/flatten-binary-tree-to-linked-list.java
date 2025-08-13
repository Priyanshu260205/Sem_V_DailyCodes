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
    public void flatten(TreeNode root) {
        make_linkedlist(root);
    }
    public TreeNode make_linkedlist(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }

        TreeNode left_tail = make_linkedlist(root.left);
        TreeNode right_tail = make_linkedlist(root.right);

        if(root.left != null){
            left_tail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        return right_tail != null ? right_tail : left_tail;
    }
}