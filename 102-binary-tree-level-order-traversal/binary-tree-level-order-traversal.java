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
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int levelsize = queue.size();
            List<Integer> currlevel = new ArrayList<>();
            for(int i=0; i<levelsize; i++){
                TreeNode currnode = queue.poll();
                currlevel.add(currnode.val);
                if(currnode.left != null){
                    queue.add(currnode.left);
                }
                if(currnode.right != null){
                    queue.add(currnode.right);
                }
            }
            result.add(currlevel);
        }
        return result;
    }
}