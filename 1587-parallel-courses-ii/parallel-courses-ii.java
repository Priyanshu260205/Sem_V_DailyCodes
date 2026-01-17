class Solution {
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        int[] pre = new int[n];

        // Build prerequisite masks
        for (int[] r : relations) {
            int u = r[0] - 1;
            int v = r[1] - 1;
            pre[v] |= (1 << u);
        }

        int maxMask = 1 << n;
        int[] dp = new int[maxMask];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < maxMask; mask++) {
            if (dp[mask] == Integer.MAX_VALUE) continue;

            int canTake = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0 && (mask & pre[i]) == pre[i]) {
                    canTake |= (1 << i);
                }
            }

            int count = Integer.bitCount(canTake);

            if (count <= k) {
                dp[mask | canTake] = Math.min(dp[mask | canTake], dp[mask] + 1);
            } else {
                for (int sub = canTake; sub > 0; sub = (sub - 1) & canTake) {
                    if (Integer.bitCount(sub) == k) {
                        dp[mask | sub] = Math.min(dp[mask | sub], dp[mask] + 1);
                    }
                }
            }
        }

        return dp[maxMask - 1];
    }
}