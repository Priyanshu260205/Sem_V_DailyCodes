class Solution {
    int[][] dp;
    public int minimizeTheDifference(int[][] mat, int target) {
        dp=new int[mat.length][4901];
        for(int i=0;i<mat.length;i++) Arrays.fill(dp[i],-1);
        return dfs(mat,0,target,0);
    }
    public int dfs(int[][] mat,int index,int target,int sum){
        if(index==mat.length){
            return Math.abs(sum-target);
        }
        if(dp[index][sum]!=-1) return dp[index][sum];
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<mat[0].length;i++){
            ans=Math.min(ans,dfs(mat,index+1,target,sum+mat[index][i]));
        }
        dp[index][sum]=ans;
        return ans;
    }
}