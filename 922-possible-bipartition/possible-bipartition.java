class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[n+1];
        int[] group = new int[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] i : dislikes){
            graph[i[0]].add(i[1]);
            graph[i[1]].add(i[0]);
        }
        for(int i=1; i<=n; i++){
            if(group[i] == 0){
                if(!dfs(graph, i, group, 1)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(List<Integer>[] graph, int node, int[] group, int color){
        group[node] = color;

        for(int i : graph[node]){
            if(group[i] == color){
                return false;
            }
            if(group[i] == 0){
                if(!dfs(graph, i, group, -color)){
                    return false;
                }
            }
        }
        return true;
    }
}