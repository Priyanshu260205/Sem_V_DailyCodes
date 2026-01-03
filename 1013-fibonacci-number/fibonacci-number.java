class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        return fibonac(dp, n);
    }

    public int fibonac(int[] dp, int n){
        if(n == 0 || n == 1){
            return n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        return dp[n] = fibonac(dp, n-1) + fibonac(dp, n-2);
    }
}