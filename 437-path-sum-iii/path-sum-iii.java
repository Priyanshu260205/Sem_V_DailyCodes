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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, 0, targetSum,map);
    }

    public int dfs(TreeNode root, long currSum, int targetSum, HashMap<Long, Integer> map){
        if(root == null) return 0;

        currSum += root.val;
        int count = map.getOrDefault(currSum-targetSum, 0);

        map.put(currSum, map.getOrDefault(currSum,0)+1);

        count += dfs(root.left, currSum, targetSum, map);
        count += dfs(root.right, currSum, targetSum, map);

        map.put(currSum, map.get(currSum)-1);

        return count;
    }
}