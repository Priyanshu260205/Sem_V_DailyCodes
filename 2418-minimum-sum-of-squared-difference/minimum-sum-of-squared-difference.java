class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int k = k1 + k2;

        int maxDiff = 0;
        int[] freq = new int[100001];

        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
            maxDiff = Math.max(maxDiff, d);
        }

        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (freq[d] == 0) continue;

            int move = Math.min(k, freq[d]);
            freq[d] -= move;
            freq[d - 1] += move;
            k -= move;
        }

        long ans = 0;
        for (int d = 0; d <= maxDiff; d++) {
            ans += (long) freq[d] * d * d;
        }

        return ans;
    }
}