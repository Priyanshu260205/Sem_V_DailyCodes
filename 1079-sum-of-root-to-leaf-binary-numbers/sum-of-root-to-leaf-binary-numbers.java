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
    int res = 0;
    public int sumRootToLeaf(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int v){
        if(root == null){
            return;
        }
        v = v*2 + root.val;
        if(root.left == null && root.right == null){
            res += v;
            return;
        }

        dfs(root.left, v); 
        dfs(root.right, v); 
    }
}