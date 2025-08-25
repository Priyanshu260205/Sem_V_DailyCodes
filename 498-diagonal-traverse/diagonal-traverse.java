class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int key = i+j;

                map.computeIfAbsent(key, k -> new ArrayList<>()).add(mat[i][j]);
            }
        }

        int[] res = new int[rows*cols];
        boolean flip = true;
        int idx = 0;

        for(int k=0; k<rows+cols-1; k++){
            List<Integer> diags = map.get(k);

            if(flip){
                Collections.reverse(diags);
            }
            flip = !flip;
            
            for(int val : diags){
                res[idx] = val;
                idx++;
            }
        }

        return res;
    }
}