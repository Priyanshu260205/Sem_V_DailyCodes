class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> matrix[a[0]][a[1]] - matrix[b[0]][b[1]]
        );

        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{i, 0});
        }

        int count = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1];

            if (++count == k) return matrix[r][c];

            if (c + 1 < n) {
                pq.offer(new int[]{r, c + 1});
            }
        }

        return -1;
    }
}