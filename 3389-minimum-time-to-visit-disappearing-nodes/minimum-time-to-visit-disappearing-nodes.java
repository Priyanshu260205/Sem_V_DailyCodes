class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj[u].add(new int[]{v, w});
            adj[v].add(new int[]{u, w});
        }

        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        if (disappear[0] > 0) {
            pq.offer(new int[]{0, 0});
            answer[0] = 0;
        }

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0];
            int u = current[1];

            if (time > answer[u] && answer[u] != -1) continue;
            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                int arrivalTime = time + weight;

                if (arrivalTime < disappear[v] && (answer[v] == -1 || arrivalTime < answer[v])) {
                    answer[v] = arrivalTime;
                    pq.offer(new int[]{arrivalTime, v});
                }
            }
        }

        return answer;
    }
}