class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int[] bitCount = new int[31];
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int currOr = 0;

        for (int right = 0; right < n; right++) {
            // Add nums[right]
            for (int b = 0; b < 31; b++) {
                if (((nums[right] >> b) & 1) == 1) {
                    bitCount[b]++;
                    currOr |= (1 << b);
                }
            }

            // Shrink while OR >= k
            while (left <= right && currOr >= k) {
                ans = Math.min(ans, right - left + 1);

                // Remove nums[left]
                for (int b = 0; b < 31; b++) {
                    if (((nums[left] >> b) & 1) == 1) {
                        bitCount[b]--;
                        if (bitCount[b] == 0) {
                            currOr &= ~(1 << b);
                        }
                    }
                }
                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}