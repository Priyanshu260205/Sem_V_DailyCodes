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
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> nodeslist = new HashSet<>();
        helper(root, nodeslist);
        return count;
    }
    private void helper(TreeNode root, Set<Integer> nodeslist){
        if(root == null){
            return;
        }
        if(nodeslist.contains(root.val)){
            nodeslist.remove(root.val);
        }
        else{
            nodeslist.add(root.val);
        }
        if(root.left == null && root.right == null){
            if(nodeslist.size() == 0 || nodeslist.size() == 1){
                count++;
            }
        }
        helper(root.left, new HashSet(nodeslist));
        helper(root.right, new HashSet(nodeslist));
    }
}