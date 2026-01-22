class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int res = 0, n = prizePositions.length, j = 0, dp[] = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            while (prizePositions[j] < prizePositions[i] - k)
                ++j;
            dp[i + 1] = Math.max(dp[i], i - j + 1);
            res = Math.max(res, i - j + 1 + dp[j]);
        }
        return res;
    }
}