class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path);

        return res;    
    }

    public void dfs(int[][] graph, int node, List<Integer> path){
        if(node == graph.length-1){
            res.add(new ArrayList<>(path));
        }

        for(int nbrs : graph[node]){
            path.add(nbrs);
            dfs(graph, nbrs, path);
            path.remove(path.size()-1);
        }
    }
}