class Solution {
    int[] prices;
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        int n = prices.length;
        dp = new Integer[n][3];
        return solve(0, 0);
    }

    public int solve(int idx, int state){
        if(idx == prices.length) return 0;

        if(dp[idx][state] != null){
            return dp[idx][state];
        }

        int res;
        int price = prices[idx];
        if(state == 0){
            res = Math.max(-price+solve(idx+1, 1), solve(idx+1, 0));
        }
        else if(state == 1){
            res = Math.max(price+solve(idx+1, 2), solve(idx+1,1));
        }
        else{
            res = solve(idx+1,0);
        }
        return dp[idx][state] = res;
    }
}