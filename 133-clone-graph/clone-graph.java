/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        map.put(node, new Node(node.val));
        q.offer(node);
        while(!q.isEmpty()){
            Node rv = q.poll();
            for(Node nbrs : rv.neighbors){
                if(!map.containsKey(nbrs)){
                    map.put(nbrs, new Node(nbrs.val));
                    q.offer(nbrs);
                }

                map.get(rv).neighbors.add(map.get(nbrs));
            }
        }
        return map.get(node);
    }
}