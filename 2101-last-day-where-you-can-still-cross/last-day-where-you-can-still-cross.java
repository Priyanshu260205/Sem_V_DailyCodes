class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int low = 1, high = row * col;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canCross(row, col, cells, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) {

        int[][] grid = new int[row][col];

        // flood cells for given day
        for (int i = 0; i < day; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 1; // water
        }

        Queue<int[]> q = new ArrayDeque<>();

        // add all dry cells in top row
        for (int c = 0; c < col; c++) {
            if (grid[0][c] == 0) {
                q.offer(new int[]{0, c});
                grid[0][c] = 1; // mark visited
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == row - 1) return true;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return false;
    }
}