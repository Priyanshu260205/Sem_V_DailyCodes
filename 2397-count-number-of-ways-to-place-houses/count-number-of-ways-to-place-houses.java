class Solution {
    public int countHousePlacements(int n) {
        long MOD = 1_000_000_007;

        long prev2 = 1; // dp[0]
        long prev1 = 2; // dp[1]

        for (int i = 2; i <= n; i++) {
            long cur = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = cur;
        }

        long waysOneSide = prev1;
        return (int)((waysOneSide * waysOneSide) % MOD);
    }
}