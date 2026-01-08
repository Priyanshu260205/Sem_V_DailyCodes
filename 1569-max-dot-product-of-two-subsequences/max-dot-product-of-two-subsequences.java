class Solution {
    int[] nums1, nums2;
    Integer[][] dp;
    static final int NEG_INF = -1_000_000_000;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        dp = new Integer[nums1.length][nums2.length];
        return solve(0, 0);
    }

    private int solve(int i, int j) {
        if (i == nums1.length || j == nums2.length) {
            return NEG_INF;
        }

        if (dp[i][j] != null) return dp[i][j];

        int take = nums1[i] * nums2[j] +
                   Math.max(0, solve(i + 1, j + 1));

        int skip1 = solve(i + 1, j);
        int skip2 = solve(i, j + 1);

        return dp[i][j] = Math.max(take, Math.max(skip1, skip2));
    }
}