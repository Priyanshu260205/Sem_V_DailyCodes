class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        Map<Integer, int[]> map = new HashMap<>();
        int rows = mat.length;
        int cols = mat[0].length;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                map.put(mat[i][j], new int[]{i,j});
            }
        }
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];
        for(int i=0; i<arr.length; i++){
            int[] temp = map.get(arr[i]);
            rowCount[temp[0]]++;
            colCount[temp[1]]++;
            if(rowCount[temp[0]] == cols || colCount[temp[1]] == rows){
                return i;
            }
        }
        return -1;
    }
}