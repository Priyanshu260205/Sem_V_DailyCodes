class Solution {
    int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    int m, n;
    
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxLen = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                maxLen = Math.max(maxLen, dfs(matrix, i, j, dp));
            }
        }
        return maxLen;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] dp){
        if(dp[i][j] != 0) return dp[i][j]; // already computed
        
        int max = 1; // length includes the cell itself
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            
            if(x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]){
                max = Math.max(max, 1 + dfs(matrix, x, y, dp));
            }
        }
        
        dp[i][j] = max;
        return max;
    }
}
