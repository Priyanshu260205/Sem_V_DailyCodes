class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        for (int i = 0; i < n; i++) {
            dist1[i] = -1;
            dist2[i] = -1;
        }

        // distances from node1
        computeDistances(edges, node1, dist1);

        // distances from node2
        computeDistances(edges, node2, dist2);

        int ans = -1;
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                if (maxDist < best) {
                    best = maxDist;
                    ans = i;
                }
            }
        }

        return ans;
    }

    private void computeDistances(int[] edges, int start, int[] dist) {
        int d = 0;
        int curr = start;

        while (curr != -1 && dist[curr] == -1) {
            dist[curr] = d++;
            curr = edges[curr];
        }
    }
}