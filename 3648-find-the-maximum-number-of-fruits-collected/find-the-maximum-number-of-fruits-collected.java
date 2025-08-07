class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int max_fru = 0;
        //c1
        for(int i=0; i<n; i++){
            max_fru += fruits[i][i];
        }

        //c2
        max_fru += getMaxFruits(fruits, n);

        //c3
        transpose(fruits, n);

        max_fru += getMaxFruits(fruits, n);

        return max_fru;
    }

    private void transpose(int[][] fruits, int n){
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp = fruits[i][j];
                fruits[i][j] = fruits[j][i];
                fruits[j][i] = temp;
            }
        }
    }

    public int getMaxFruits(int[][] fruits, int n){
        int[] prev = new int[n];

        for(int i=0; i<n; i++){
            prev[i] = i != n-1 ? Integer.MIN_VALUE : fruits[0][n-1];
        }
        for(int row=1; row < n-1; row++){ 
            int[] curr = new int[n];

            for(int i=0; i<n; i++){
                curr[i] = Integer.MIN_VALUE;
            }

            for(int col=0; col < n; col++){
                int maxValue = Integer.MIN_VALUE;

                if((col - 1) >= 0){
                    maxValue = Math.max(maxValue, prev[col - 1]);
                }

                maxValue = Math.max(maxValue, prev[col]);
                if((col + 1) < n){
                    maxValue = Math.max(maxValue, prev[col+1]);
                }

                if(maxValue != Integer.MIN_VALUE){
                    curr[col] = maxValue + fruits[row][col];
                }
            }

            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[n-1];
    }
}