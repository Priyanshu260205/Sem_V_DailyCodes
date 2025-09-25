class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[triangle.size()][triangle.get(triangle.size()-1).size()];
        return helper(triangle, 0, 0, dp);
    }

    public int helper(List<List<Integer>> triangle, int c_rowi, int c_coli, Integer[][] dp){
        if(c_rowi == triangle.size()){
            return 0;
        }
        if(dp[c_rowi][c_coli] != null){
            return dp[c_rowi][c_coli];
        }

        int res = triangle.get(c_rowi).get(c_coli) + 
        Math.min(helper(triangle, c_rowi+1, c_coli, dp) , helper(triangle, c_rowi+1, c_coli+1, dp));

        return dp[c_rowi][c_coli] = res;
    }
}