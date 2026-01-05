class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> blocked = new HashSet<>();
        int max = x;
        for (int f : forbidden) {
            blocked.add(f);
            max = Math.max(max, f);
        }

        int limit = max + a + b;

        // visited[pos][0] -> last move was forward
        // visited[pos][1] -> last move was backward
        boolean[][] visited = new boolean[limit + 1][2];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0}); // {position, lastBackward(0/1)}
        visited[0][0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int pos = curr[0];
                int back = curr[1];

                if (pos == x) return steps;

                // Forward jump
                int forward = pos + a;
                if (forward <= limit &&
                    !blocked.contains(forward) &&
                    !visited[forward][0]) {

                    visited[forward][0] = true;
                    q.offer(new int[]{forward, 0});
                }

                // Backward jump (only if last wasn't backward)
                int backward = pos - b;
                if (back == 0 &&
                    backward >= 0 &&
                    !blocked.contains(backward) &&
                    !visited[backward][1]) {

                    visited[backward][1] = true;
                    q.offer(new int[]{backward, 1});
                }
            }
            steps++;
        }

        return -1;
    }
}