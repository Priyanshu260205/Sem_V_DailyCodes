class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0}); // {time, node}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0];
            int u = cur[1];

            if (time > dist[u]) continue;

            for (int[] nei : graph[u]) {
                int v = nei[0];
                int w = nei[1];
                int newTime = time + w;

                // Must arrive strictly before disappearance
                if (newTime < disappear[v] && newTime < dist[v]) {
                    dist[v] = newTime;
                    pq.offer(new int[]{newTime, v});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}