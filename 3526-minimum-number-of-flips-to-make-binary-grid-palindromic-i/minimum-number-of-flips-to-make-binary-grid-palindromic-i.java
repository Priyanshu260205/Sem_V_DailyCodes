class Solution {
    public int minFlips(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int rowflips = 0;
        for(int i=0; i<rows; i++){
            rowflips += findMinFlips(grid[i]);
        }
        int colflips = 0;
        for(int i=0; i<cols; i++){
            int[] columns = new int[rows];
            for(int j=0; j<rows; j++){
                columns[j] = grid[j][i];
            }
            colflips += findMinFlips(columns);
        }
        return Math.min(rowflips, colflips);
    }

    private int findMinFlips(int [] arr){
        int flips = 0;
        int start = 0, end = arr.length-start-1;
        while(start < end){
            if(arr[start] != arr[end]){
                flips++;
            }
            start++;
            end--;
        }
        return flips;
    }
}