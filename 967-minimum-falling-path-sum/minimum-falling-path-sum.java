class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for(int col=0; col<cols; col++){
            dp[0][col] = matrix[0][col];
        }
        for(int row=1; row<rows; row++){
            for(int col=0; col<cols; col++){
                int top_left = Integer.MAX_VALUE, top_right = Integer.MAX_VALUE, top = Integer.MAX_VALUE;
                if(col-1 >= 0){
                    top_left = dp[row-1][col-1];
                }
                if(row - 1 >= 0 && col+1 < cols){
                    top_right = dp[row-1][col+1];
                }
                if(row - 1 >= 0){
                    top = dp[row-1][col];
                }
                dp[row][col] = matrix[row][col] + Math.min(Math.min(top_left, top), top_right);
            }
        }
        int min_sum = Integer.MAX_VALUE;
        for(int col=0; col<cols; col++){
            min_sum = Math.min(min_sum, dp[rows-1][col]);
        }
        return min_sum;
    }
}