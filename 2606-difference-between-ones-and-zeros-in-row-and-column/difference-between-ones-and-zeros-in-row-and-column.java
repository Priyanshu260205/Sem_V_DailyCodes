class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] diff = new int[rows][cols];
        int[] ones_r = new int[rows];
        int[] ones_c = new int[cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                ones_r[i] += grid[i][j];
                ones_c[j] += grid[i][j];
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                diff[i][j] = ones_r[i] + ones_c[j] - (rows - ones_r[i]) - (cols - ones_c[j]);
            }
        }
        return diff;
    }
}