class Solution {
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int res = 0;

        int heights[] = new int[cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                heights[j] = mat[i][j] == 0 ? 0 : heights[j] + 1;
            }
            res += helper(mat, heights);
        }
        return res;
    }

    private int helper(int[][] mat, int[] heights){
        int result = 0;
        int rows = mat.length;
        int cols = mat[0].length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] sum = new int[cols];

        for(int j=0; j<cols; j++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[j]){
                st.pop();
            }
            if(!st.isEmpty()){
                int prev = st.peek();
                sum[j] = sum[prev] + heights[j] * (j - prev);
            }
            else
            {
                sum[j] = heights[j] * (j+1);
            }
            result += sum[j];
            st.push(j);
        }
        return result;
    }
}