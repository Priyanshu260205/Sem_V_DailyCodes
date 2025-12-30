class Solution {
    public int minCost(int n, int[][] edges) {
        List<long[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            // Normal directed edge
            adj[u].add(new long[]{v, (long)w}); 
            // Reversible edge: cost is 2 * w
            adj[v].add(new long[]{u, 2L * w}); 
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        // PriorityQueue stores {cost, node}
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            long d = current[0];
            int u = (int) current[1];

            if (d > dist[u]) continue;

            for (long[] edge : adj[u]) {
                int v = (int) edge[0];
                long weight = edge[1];
                
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new long[]{dist[v], (long)v});
                }
            }
        }

        // Check if destination is reachable and cast to int
        if (dist[n - 1] == Long.MAX_VALUE) {
            return -1;
        }
        return (int) dist[n - 1];
    }
}