class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean[] bad = new boolean[n - 1];
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] > maxDiff) {
                bad[i] = true;
            }
        }
        int[] prefix = new int[n];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (bad[i - 1] ? 1 : 0);
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int l = Math.min(u, v);
            int r = Math.max(u, v);

            ans[i] = (prefix[r] - prefix[l] == 0);
        }

        return ans;
    }
}