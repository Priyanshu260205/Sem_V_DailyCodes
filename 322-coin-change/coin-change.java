class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -2);
        return dfs(coins, amount, dp);
    }

    public int dfs(int[] coins, int amount, int[] dp){
        if(amount == 0){
            return 0;
        }
        if(amount <= 0){
            return -1;
        }
        if(dp[amount] != -2){
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for(int c : coins){
            int res = dfs(coins, amount-c, dp);
            if(res >= 0){
                min = Math.min(min, res+1);
            }
        }

        dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount];
    }
}