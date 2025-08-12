class Solution {
    private int MOD = 1_000_000_007;
    public int numberOfWays(int n, int x) {
        Integer[][] memo = new Integer[n+1][n+1];
        return helper(n, 1, x, memo);
    }

    private int calc_pow(int a, int power, Integer[][] memo){
        long result = 1;

        for(int i=0; i<power; i++){
            result = result * a;
        }

        return (int) result;
    }

    private int helper(int remaining, int current, int power, Integer[][] memo){

        if(remaining < 0){
            return 0;
        }
        if(remaining == 0){
            return 1; 
        }
        int curr_power = calc_pow(current, power, memo);
        if(curr_power > remaining){
            return 0;
        }

        if(memo[remaining][current] != null){
            return memo[remaining][current];
        }

        int pick = helper(remaining - curr_power, current + 1, power, memo) % MOD;

        int not_pick = helper(remaining, current + 1, power, memo) % MOD;

        memo[remaining][current] = (pick + not_pick) % MOD;

        return memo[remaining][current];
    }
}