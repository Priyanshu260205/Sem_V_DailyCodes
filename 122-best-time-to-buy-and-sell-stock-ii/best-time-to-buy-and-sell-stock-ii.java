class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for(int i=1; i<prices.length; i++){
            if(prices[i] > prices[i-1]){
                dp[i] = prices[i] - prices[i-1];
            }
        }

        int res = 0;
        for(int i : dp){
            res += i;
        }
        return res;
    }
}