class Solution {
    static final int MOD = 1_000_000_007;
    List<int[]>[] graph;
    long[] dist;
    Integer[] dp;

    public int countRestrictedPaths(int n, int[][] edges) {
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        // Step 1: Dijkstra from node n
        dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dijkstra(n);

        // Step 2: DFS + DP
        dp = new Integer[n + 1];
        return dfs(1, n);
    }

    private void dijkstra(int start) {
        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0])
        );
        pq.offer(new long[]{0, start});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long d = curr[0];
            int u = (int) curr[1];

            if (d > dist[u]) continue;

            for (int[] nei : graph[u]) {
                int v = nei[0];
                long w = nei[1];
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.offer(new long[]{dist[v], v});
                }
            }
        }
    }

    private int dfs(int u, int n) {
        if (u == n) return 1;
        if (dp[u] != null) return dp[u];

        int ways = 0;
        for (int[] nei : graph[u]) {
            int v = nei[0];
            if (dist[v] < dist[u]) {
                ways = (ways + dfs(v, n)) % MOD;
            }
        }

        return dp[u] = ways;
    }
}