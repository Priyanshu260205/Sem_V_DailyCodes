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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> hm = new HashMap<>();
        convert_TreetoGraph(root, 0, hm);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        int minutes = 0;
        while(!queue.isEmpty()){
            int level_size = queue.size();
            while(level_size > 0){
                int curr = queue.poll();
                for(int num: hm.get(curr)){
                    if(!visited.contains(num)){
                        queue.add(num);
                        visited.add(num);
                    }
                }
                level_size--;
            }
            minutes++;
        }
        return minutes-1;
    }

    public void convert_TreetoGraph(TreeNode current, int parent, Map<Integer, Set<Integer>> map){
        if(current != null){
            if(!map.containsKey(current.val)){
                map.put(current.val, new HashSet<>());
            }
            Set<Integer> adjacentList = map.get(current.val);
            if(parent != 0){
                adjacentList.add(parent);
            }
            if(current.left != null){
                adjacentList.add(current.left.val);
            }
            if(current.right != null){
                adjacentList.add(current.right.val);
            }
            convert_TreetoGraph(current.left, current.val, map);
            convert_TreetoGraph(current.right, current.val, map);

        }
    }
}