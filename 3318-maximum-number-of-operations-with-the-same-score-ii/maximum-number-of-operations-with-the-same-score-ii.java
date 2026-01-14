class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;

        int[] targets = {
            nums[0] + nums[1],
            nums[n - 2] + nums[n - 1],
            nums[0] + nums[n - 1]
        };

        for (int target : targets) {
            int[][] dp = new int[n][n];

            for (int len = 2; len <= n; len++) {
                for (int l = 0; l + len - 1 < n; l++) {
                    int r = l + len - 1;

                    // first two
                    if (l + 1 <= r && nums[l] + nums[l + 1] == target) {
                        dp[l][r] = Math.max(dp[l][r],
                                1 + (l + 2 <= r ? dp[l + 2][r] : 0));
                    }
                    if (l <= r - 1 && nums[r - 1] + nums[r] == target) {
                        dp[l][r] = Math.max(dp[l][r],
                                1 + (l <= r - 2 ? dp[l][r - 2] : 0));
                    }
                    if (nums[l] + nums[r] == target) {
                        dp[l][r] = Math.max(dp[l][r],
                                1 + (l + 1 <= r - 1 ? dp[l + 1][r - 1] : 0));
                    }
                }
            }

            ans = Math.max(ans, dp[0][n - 1]);
        }

        return ans;
    }
}