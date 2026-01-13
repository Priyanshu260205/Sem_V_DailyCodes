class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int maxMask = 1 << n;

        int[] dp = new int[maxMask];
        int[] remain = new int[maxMask];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 1;
        remain[0] = sessionTime;

        for (int mask = 0; mask < maxMask; mask++) {
            if (dp[mask] == Integer.MAX_VALUE) continue;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) continue;

                int nextMask = mask | (1 << i);

                if (remain[mask] >= tasks[i]) {
                    // Same session
                    if (dp[nextMask] > dp[mask] ||
                       (dp[nextMask] == dp[mask] &&
                        remain[nextMask] < remain[mask] - tasks[i])) {

                        dp[nextMask] = dp[mask];
                        remain[nextMask] = remain[mask] - tasks[i];
                    }
                } else {
                    // New session
                    if (dp[nextMask] > dp[mask] + 1) {
                        dp[nextMask] = dp[mask] + 1;
                        remain[nextMask] = sessionTime - tasks[i];
                    }
                }
            }
        }

        return dp[maxMask - 1];
    }
}