class Solution {
    public int findMinimumTime(List<Integer> strength, int k) {
        int n = strength.size();
        int totalMasks = 1 << n;

        int[] dp = new int[totalMasks];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int mask = 0; mask < totalMasks; mask++) {
            int broken = Integer.bitCount(mask);
            int x = 1 + broken * k;

            for (int i = 0; i < n; i++) {
                // If lock i is not yet broken
                if ((mask & (1 << i)) == 0) {
                    int needed = strength.get(i);
                    int time = (needed + x - 1) / x; // ceil division
                    int nextMask = mask | (1 << i);

                    dp[nextMask] = Math.min(dp[nextMask], dp[mask] + time);
                }
            }
        }

        return dp[totalMasks - 1];
    }
}