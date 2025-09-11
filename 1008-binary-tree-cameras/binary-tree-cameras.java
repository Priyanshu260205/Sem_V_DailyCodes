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
    int Camera = 0;
    public int minCameraCover(TreeNode root) {
        int cam_min = minCamera(root);
        if(cam_min == -1){
            Camera++;
        }
        return Camera;
    }
    public int minCamera(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = minCamera(root.left);
        int right = minCamera(root.right);

        if(left==-1 || right==-1){
            Camera++;
            return 1;// Iska matlab Camera set ho gya hai is node par
        }
        else if(left==1 || right==1){
            return 0; //Iska matlab Camera ki fielding already set hai
        }
        else{
            return -1; //Camera is required by the parent
        }

    }
}