class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp, 0);
        for(int start=arr.length-1; start>=0; start--){
            int currmax = 0;
            int end = Math.min(arr.length, start+k);
            for(int i=start; i<end; i++){
                currmax = Math.max(currmax, arr[i]);
                dp[start] = Math.max(dp[start], currmax*(i-start+1) + dp[i+1]);
            }
        }
        return dp[0];
    }
}