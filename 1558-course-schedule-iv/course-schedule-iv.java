class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = numCourses;
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] ed : prerequisites){
            adj.get(ed[0]).add(ed[1]);
        }

        boolean[][] canReach = new boolean[n][n];
        for (int i = 0; i < n; i++){
            boolean[] vis = new boolean[n];
            dfs(adj, i, vis);
            for (int j = 0; j < n; j++){
                canReach[i][j] = vis[j];
            }
        }

        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries){
            int u = q[0], v = q[1];
            ans.add(canReach[u][v]);
        }

        return ans;
    }

    public void dfs(List<List<Integer>> adj, int st, boolean[] vis){
        if (vis[st]) return;
        vis[st] = true;
        for (int de : adj.get(st)){
            dfs(adj, de, vis);
        }
    }
}