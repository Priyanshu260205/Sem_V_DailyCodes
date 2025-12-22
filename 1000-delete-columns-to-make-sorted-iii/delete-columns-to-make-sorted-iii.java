class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();

        int[] dp = new int[cols];
        Arrays.fill(dp, 1);

        int maxKeep = 1;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < i; j++) {
                if (isValid(strs, j, i, rows)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxKeep = Math.max(maxKeep, dp[i]);
        }

        return cols - maxKeep;
    }

    private boolean isValid(String[] strs, int c1, int c2, int rows) {
        for (int r = 0; r < rows; r++) {
            if (strs[r].charAt(c1) > strs[r].charAt(c2)) {
                return false;
            }
        }
        return true;
    }
}