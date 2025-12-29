class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        TreeSet<Integer> costSet = new TreeSet<>();
        for (int[] e : edges) costSet.add(e[2]);
        List<Integer> sortedCosts = new ArrayList<>(costSet);
        
        int low = 0, high = sortedCosts.size() - 1;
        int result = -1;
        int n = online.length;
        
        // Build adjacency list
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
        }
        
        // Pre-calculate topological order for DAG
        int[] topoOrder = getTopologicalOrder(n, adj);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int minEdgeAllowed = sortedCosts.get(mid);
            
            if (isPossible(n, adj, topoOrder, online, k, minEdgeAllowed)) {
                result = minEdgeAllowed;
                low = mid + 1; // Try for a larger minimum edge cost
            } else {
                high = mid - 1;
            }
        }
        
        return result;
    }

    private boolean isPossible(int n, List<int[]>[] adj, int[] topoOrder, boolean[] online, long k, int threshold) {
        long[] minCost = new long[n];
        Arrays.fill(minCost, Long.MAX_VALUE / 2);
        minCost[0] = 0;

        for (int u : topoOrder) {
            if (minCost[u] > k) continue;
            // Intermediate nodes must be online (0 and n-1 are always online)
            if (u != 0 && u != n - 1 && !online[u]) continue;

            for (int[] edge : adj[u]) {
                int v = edge[0];
                int weight = edge[1];
                
                // Only use edges that meet our binary search threshold
                if (weight >= threshold) {
                    if (minCost[u] + weight < minCost[v]) {
                        minCost[v] = minCost[u] + weight;
                    }
                }
            }
        }
        return minCost[n - 1] <= k;
    }

    private int[] getTopologicalOrder(int n, List<int[]>[] adj) {
        int[] inDegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (int[] e : adj[u]) inDegree[e[0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (inDegree[i] == 0) q.add(i);
        
        int[] order = new int[n];
        int idx = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            order[idx++] = u;
            for (int[] e : adj[u]) {
                if (--inDegree[e[0]] == 0) q.add(e[0]);
            }
        }
        return order;
    }
}