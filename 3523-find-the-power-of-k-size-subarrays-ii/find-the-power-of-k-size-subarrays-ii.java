class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        int len = 1; // length of current consecutive +1 sequence

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1] + 1) {
                len++;
            } else {
                len = 1;
            }

            if (i >= k - 1) {
                if (len >= k) {
                    ans[i - k + 1] = nums[i];
                } else {
                    ans[i - k + 1] = -1;
                }
            }
        }
        return ans;
    }
}