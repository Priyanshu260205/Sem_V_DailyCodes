class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[k][k];
        int maxLen = 0;

        for (int x : nums) {
            int currentRem = x % k;
            
            for (int targetSum = 0; targetSum < k; targetSum++) {
                int prevRem = (targetSum - currentRem + k) % k;
                
                dp[currentRem][targetSum] = dp[prevRem][targetSum] + 1;
                maxLen = Math.max(maxLen, dp[currentRem][targetSum]);
            }
        }

        return maxLen;
    }
}